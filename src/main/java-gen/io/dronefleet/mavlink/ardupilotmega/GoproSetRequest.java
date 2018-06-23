package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request to set a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GoproCommand} with a desired 
 */
@MavlinkMessageInfo(
        id = 218,
        crc = 17
)
public final class GoproSetRequest {
    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * Command ID 
     */
    private final GoproCommand cmdId;

    /**
     * Value 
     */
    private final byte[] value;

    private GoproSetRequest(int targetSystem, int targetComponent, GoproCommand cmdId,
            byte[] value) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.cmdId = cmdId;
        this.value = value;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GoproSetRequest{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", cmdId=" + cmdId
                 + ", value=" + value + "}";
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    /**
     * Command ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final GoproCommand cmdId() {
        return cmdId;
    }

    /**
     * Value 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 4
    )
    public final byte[] value() {
        return value;
    }

    public static class Builder {
        private int targetSystem;

        private int targetComponent;

        private GoproCommand cmdId;

        private byte[] value;

        private Builder() {
        }

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Command ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder cmdId(GoproCommand cmdId) {
            this.cmdId = cmdId;
            return this;
        }

        /**
         * Value 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 4
        )
        public final Builder value(byte[] value) {
            this.value = value;
            return this;
        }

        public final GoproSetRequest build() {
            return new GoproSetRequest(targetSystem, targetComponent, cmdId, value);
        }
    }
}
