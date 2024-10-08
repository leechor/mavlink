package io.dronefleet.mavlink;

import io.dronefleet.mavlink.minimal.Heartbeat;
import io.dronefleet.mavlink.minimal.MavAutopilot;
import io.dronefleet.mavlink.minimal.MavState;
import io.dronefleet.mavlink.minimal.MavType;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MavlinkConnectionTest {

    private PipedInputStream in;
    private PipedOutputStream out;
    private MavlinkConnection source;

    @BeforeEach
    public void setUp() throws IOException {
        in = new PipedInputStream();
        out = new PipedOutputStream();
        source = MavlinkConnection.create(
                new PipedInputStream(out),
                new PipedOutputStream(in));
    }

    @Test
    public void itUsesDefaultDialectByDefault() throws IOException {
        MavlinkDialect dialect = new AbstractMavlinkDialect(
                "testdialect",
                Collections.emptyList(),
                new UnmodifiableMapBuilder<Integer, Class<?>>()
                        .put(0, TestMessage.class)
                        .build());

        MavlinkConnection target = MavlinkConnection.builder(in, out)
                .defaultDialect(dialect)
                .build();

        Object expected = TestMessage.builder()
                .text("Test")
                .build();
        source.send1(0, 0, expected);

        Object actual = target.next().getPayload();

        assertEquals(expected, actual);
    }

    @Test
    public void itUsesCommonDialectAsFallback() throws IOException {
        MavlinkDialect dialect = new AbstractMavlinkDialect(
                "testdialect",
                Collections.emptyList(),
                new UnmodifiableMapBuilder<Integer, Class<?>>()
                        .put(0, TestMessage.class)
                        .build());

        MavlinkConnection target = MavlinkConnection.builder(in, out)
                .defaultDialect(dialect)
                .build();

        Object expected = Heartbeat.builder()
                .autopilot(MavAutopilot.MAV_AUTOPILOT_GENERIC)
                .type(MavType.MAV_TYPE_GENERIC)
                .systemStatus(MavState.MAV_STATE_UNINIT)
                .baseMode()
                .mavlinkVersion(3)
                .build();
        source.send1(0, 0, expected);

        Object actual = target.next().getPayload();

        assertEquals(expected, actual);
    }

    @Test
    public void defaultDialectDoesNotPreventHeartbeatFromConfiguringDialect() throws IOException {
        MavlinkDialect defaultDialect = new AbstractMavlinkDialect(
                "testdialect",
                Collections.emptyList(),
                new UnmodifiableMapBuilder<Integer, Class<?>>()
                        .put(0, TestMessage.class)
                        .build());

        MavlinkDialect expected = new AbstractMavlinkDialect(
                "expecteddialect",
                Collections.emptyList(),
                Collections.emptyMap());

        MavlinkConnection target = MavlinkConnection.builder(in, out)
                .dialect(MavAutopilot.MAV_AUTOPILOT_GENERIC, expected)
                .defaultDialect(defaultDialect)
                .build();

        source.send1(0, 0, Heartbeat.builder()
                .autopilot(MavAutopilot.MAV_AUTOPILOT_GENERIC)
                .type(MavType.MAV_TYPE_GENERIC)
                .systemStatus(MavState.MAV_STATE_UNINIT)
                .baseMode()
                .mavlinkVersion(3)
                .build());

        target.next();
        MavlinkDialect actual = target.getDialect(0);

        assertEquals(expected, actual);
    }
}