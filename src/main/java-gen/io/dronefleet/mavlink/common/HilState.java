package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * DEPRECATED PACKET! Suffers from missing airspeed fields and singularities due to Euler 
 * angles. Please use HIL_STATE_QUATERNION instead. Sent from simulation to autopilot. This 
 * packet is useful for high throughput applications such as hardware in the loop simulations. 
 */
@MavlinkMessageInfo(
        id = 90,
        crc = 183
)
public final class HilState {
    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    private final BigInteger timeUsec;

    /**
     * Roll angle (rad) 
     */
    private final float roll;

    /**
     * Pitch angle (rad) 
     */
    private final float pitch;

    /**
     * Yaw angle (rad) 
     */
    private final float yaw;

    /**
     * Body frame roll / phi angular speed (rad/s) 
     */
    private final float rollspeed;

    /**
     * Body frame pitch / theta angular speed (rad/s) 
     */
    private final float pitchspeed;

    /**
     * Body frame yaw / psi angular speed (rad/s) 
     */
    private final float yawspeed;

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    private final int lat;

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    private final int lon;

    /**
     * Altitude in meters, expressed as * 1000 (millimeters) 
     */
    private final int alt;

    /**
     * Ground X Speed (Latitude), expressed as m/s * 100 
     */
    private final int vx;

    /**
     * Ground Y Speed (Longitude), expressed as m/s * 100 
     */
    private final int vy;

    /**
     * Ground Z Speed (Altitude), expressed as m/s * 100 
     */
    private final int vz;

    /**
     * X acceleration (mg) 
     */
    private final int xacc;

    /**
     * Y acceleration (mg) 
     */
    private final int yacc;

    /**
     * Z acceleration (mg) 
     */
    private final int zacc;

    private HilState(BigInteger timeUsec, float roll, float pitch, float yaw, float rollspeed,
            float pitchspeed, float yawspeed, int lat, int lon, int alt, int vx, int vy, int vz,
            int xacc, int yacc, int zacc) {
        this.timeUsec = timeUsec;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.rollspeed = rollspeed;
        this.pitchspeed = pitchspeed;
        this.yawspeed = yawspeed;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.xacc = xacc;
        this.yacc = yacc;
        this.zacc = zacc;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "HilState{timeUsec=" + timeUsec
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", rollspeed=" + rollspeed
                 + ", pitchspeed=" + pitchspeed
                 + ", yawspeed=" + yawspeed
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", vx=" + vx
                 + ", vy=" + vy
                 + ", vz=" + vz
                 + ", xacc=" + xacc
                 + ", yacc=" + yacc
                 + ", zacc=" + zacc + "}";
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return timeUsec;
    }

    /**
     * Roll angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float roll() {
        return roll;
    }

    /**
     * Pitch angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float pitch() {
        return pitch;
    }

    /**
     * Yaw angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float yaw() {
        return yaw;
    }

    /**
     * Body frame roll / phi angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float rollspeed() {
        return rollspeed;
    }

    /**
     * Body frame pitch / theta angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float pitchspeed() {
        return pitchspeed;
    }

    /**
     * Body frame yaw / psi angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float yawspeed() {
        return yawspeed;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return lat;
    }

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            signed = true
    )
    public final int lon() {
        return lon;
    }

    /**
     * Altitude in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            signed = true
    )
    public final int alt() {
        return alt;
    }

    /**
     * Ground X Speed (Latitude), expressed as m/s * 100 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            signed = true
    )
    public final int vx() {
        return vx;
    }

    /**
     * Ground Y Speed (Longitude), expressed as m/s * 100 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            signed = true
    )
    public final int vy() {
        return vy;
    }

    /**
     * Ground Z Speed (Altitude), expressed as m/s * 100 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            signed = true
    )
    public final int vz() {
        return vz;
    }

    /**
     * X acceleration (mg) 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            signed = true
    )
    public final int xacc() {
        return xacc;
    }

    /**
     * Y acceleration (mg) 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            signed = true
    )
    public final int yacc() {
        return yacc;
    }

    /**
     * Z acceleration (mg) 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 2,
            signed = true
    )
    public final int zacc() {
        return zacc;
    }

    public static class Builder {
        private BigInteger timeUsec;

        private float roll;

        private float pitch;

        private float yaw;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        private int lat;

        private int lon;

        private int alt;

        private int vx;

        private int vy;

        private int vz;

        private int xacc;

        private int yacc;

        private int zacc;

        private Builder() {
        }

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Roll angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Body frame roll / phi angular speed (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder rollspeed(float rollspeed) {
            this.rollspeed = rollspeed;
            return this;
        }

        /**
         * Body frame pitch / theta angular speed (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder pitchspeed(float pitchspeed) {
            this.pitchspeed = pitchspeed;
            return this;
        }

        /**
         * Body frame yaw / psi angular speed (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder yawspeed(float yawspeed) {
            this.yawspeed = yawspeed;
            return this;
        }

        /**
         * Latitude, expressed as degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude, expressed as degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                signed = true
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude in meters, expressed as * 1000 (millimeters) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                signed = true
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Ground X Speed (Latitude), expressed as m/s * 100 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                signed = true
        )
        public final Builder vx(int vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Ground Y Speed (Longitude), expressed as m/s * 100 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                signed = true
        )
        public final Builder vy(int vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Ground Z Speed (Altitude), expressed as m/s * 100 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                signed = true
        )
        public final Builder vz(int vz) {
            this.vz = vz;
            return this;
        }

        /**
         * X acceleration (mg) 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                signed = true
        )
        public final Builder xacc(int xacc) {
            this.xacc = xacc;
            return this;
        }

        /**
         * Y acceleration (mg) 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2,
                signed = true
        )
        public final Builder yacc(int yacc) {
            this.yacc = yacc;
            return this;
        }

        /**
         * Z acceleration (mg) 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 2,
                signed = true
        )
        public final Builder zacc(int zacc) {
            this.zacc = zacc;
            return this;
        }

        public final HilState build() {
            return new HilState(timeUsec, roll, pitch, yaw, rollspeed, pitchspeed, yawspeed, lat, lon, alt, vx, vy, vz, xacc, yacc, zacc);
        }
    }
}
