package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * WIP: Version and capability of protocol version. This message is the response to 
 * REQUEST_PROTOCOL_VERSION and is used as part of the handshaking to establish which MAVLink 
 * version should be used on the network. Every node should respond to REQUEST_PROTOCOL_VERSION 
 * to enable the handshaking. Library implementers should consider adding this into the default 
 * decoding state machine to allow the protocol core to respond directly. 
 */
@MavlinkMessageInfo(
        id = 300,
        crc = 217
)
public final class ProtocolVersion {
    /**
     * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc. 
     */
    private final int version;

    /**
     * Minimum MAVLink version supported 
     */
    private final int minVersion;

    /**
     * Maximum MAVLink version supported (set to the same value as version by default) 
     */
    private final int maxVersion;

    /**
     * The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    private final byte[] specVersionHash;

    /**
     * The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    private final byte[] libraryVersionHash;

    private ProtocolVersion(int version, int minVersion, int maxVersion, byte[] specVersionHash,
            byte[] libraryVersionHash) {
        this.version = version;
        this.minVersion = minVersion;
        this.maxVersion = maxVersion;
        this.specVersionHash = specVersionHash;
        this.libraryVersionHash = libraryVersionHash;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "ProtocolVersion{version=" + version
                 + ", minVersion=" + minVersion
                 + ", maxVersion=" + maxVersion
                 + ", specVersionHash=" + specVersionHash
                 + ", libraryVersionHash=" + libraryVersionHash + "}";
    }

    /**
     * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int version() {
        return version;
    }

    /**
     * Minimum MAVLink version supported 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int minVersion() {
        return minVersion;
    }

    /**
     * Maximum MAVLink version supported (set to the same value as version by default) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int maxVersion() {
        return maxVersion;
    }

    /**
     * The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 8
    )
    public final byte[] specVersionHash() {
        return specVersionHash;
    }

    /**
     * The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 8
    )
    public final byte[] libraryVersionHash() {
        return libraryVersionHash;
    }

    public static class Builder {
        private int version;

        private int minVersion;

        private int maxVersion;

        private byte[] specVersionHash;

        private byte[] libraryVersionHash;

        private Builder() {
        }

        /**
         * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder version(int version) {
            this.version = version;
            return this;
        }

        /**
         * Minimum MAVLink version supported 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder minVersion(int minVersion) {
            this.minVersion = minVersion;
            return this;
        }

        /**
         * Maximum MAVLink version supported (set to the same value as version by default) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder maxVersion(int maxVersion) {
            this.maxVersion = maxVersion;
            return this;
        }

        /**
         * The first 8 bytes (not characters printed in hex!) of the git hash. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 8
        )
        public final Builder specVersionHash(byte[] specVersionHash) {
            this.specVersionHash = specVersionHash;
            return this;
        }

        /**
         * The first 8 bytes (not characters printed in hex!) of the git hash. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 8
        )
        public final Builder libraryVersionHash(byte[] libraryVersionHash) {
            this.libraryVersionHash = libraryVersionHash;
            return this;
        }

        public final ProtocolVersion build() {
            return new ProtocolVersion(version, minVersion, maxVersion, specVersionHash, libraryVersionHash);
        }
    }
}
