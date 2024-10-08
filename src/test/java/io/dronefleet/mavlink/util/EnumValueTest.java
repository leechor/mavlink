package io.dronefleet.mavlink.util;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EnumValueTest {
    @MavlinkEnum(
            bitmask = true
    )
    public enum MavModeFlagDecodePosition {
        @MavlinkEntryInfo(128)
        MAV_MODE_FLAG_DECODE_POSITION_SAFETY,
        @MavlinkEntryInfo(64)
        MAV_MODE_FLAG_DECODE_POSITION_MANUAL,
        @MavlinkEntryInfo(32)
        MAV_MODE_FLAG_DECODE_POSITION_HIL,
        @MavlinkEntryInfo(16)
        MAV_MODE_FLAG_DECODE_POSITION_STABILIZE,
        @MavlinkEntryInfo(8)
        MAV_MODE_FLAG_DECODE_POSITION_GUIDED,
        @MavlinkEntryInfo(4)
        MAV_MODE_FLAG_DECODE_POSITION_AUTO,
        @MavlinkEntryInfo(2)
        MAV_MODE_FLAG_DECODE_POSITION_TEST,
        @MavlinkEntryInfo(1)
        MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE;

        private MavModeFlagDecodePosition() {
        }
    }

    @Test
    void testDecompose() {
        EnumValue<MavModeFlagDecodePosition> value = EnumValue.create(
                MavModeFlagDecodePosition.MAV_MODE_FLAG_DECODE_POSITION_AUTO,
                MavModeFlagDecodePosition.MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE
        );

        assertArrayEquals(
                new MavModeFlagDecodePosition[]{
                        MavModeFlagDecodePosition.MAV_MODE_FLAG_DECODE_POSITION_AUTO,
                        MavModeFlagDecodePosition.MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE
                },
                EnumValue.decompose(value).toArray()
        );
    }

}