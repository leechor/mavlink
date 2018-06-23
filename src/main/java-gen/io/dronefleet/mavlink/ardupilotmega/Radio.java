package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Status generated by radio 
 */
@MavlinkMessageInfo(
        id = 166,
        crc = 21
)
public final class Radio {
    /**
     * receive errors 
     */
    private final int rxerrors;

    /**
     * count of error corrected packets 
     */
    private final int fixed;

    /**
     * local signal strength 
     */
    private final int rssi;

    /**
     * remote signal strength 
     */
    private final int remrssi;

    /**
     * how full the tx buffer is as a percentage 
     */
    private final int txbuf;

    /**
     * background noise level 
     */
    private final int noise;

    /**
     * remote background noise level 
     */
    private final int remnoise;

    private Radio(int rxerrors, int fixed, int rssi, int remrssi, int txbuf, int noise,
            int remnoise) {
        this.rxerrors = rxerrors;
        this.fixed = fixed;
        this.rssi = rssi;
        this.remrssi = remrssi;
        this.txbuf = txbuf;
        this.noise = noise;
        this.remnoise = remnoise;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Radio{rssi=" + rssi
                 + ", remrssi=" + remrssi
                 + ", txbuf=" + txbuf
                 + ", noise=" + noise
                 + ", remnoise=" + remnoise
                 + ", rxerrors=" + rxerrors
                 + ", fixed=" + fixed + "}";
    }

    /**
     * receive errors 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int rxerrors() {
        return rxerrors;
    }

    /**
     * count of error corrected packets 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int fixed() {
        return fixed;
    }

    /**
     * local signal strength 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int rssi() {
        return rssi;
    }

    /**
     * remote signal strength 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int remrssi() {
        return remrssi;
    }

    /**
     * how full the tx buffer is as a percentage 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int txbuf() {
        return txbuf;
    }

    /**
     * background noise level 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int noise() {
        return noise;
    }

    /**
     * remote background noise level 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int remnoise() {
        return remnoise;
    }

    public static class Builder {
        private int rxerrors;

        private int fixed;

        private int rssi;

        private int remrssi;

        private int txbuf;

        private int noise;

        private int remnoise;

        private Builder() {
        }

        /**
         * receive errors 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder rxerrors(int rxerrors) {
            this.rxerrors = rxerrors;
            return this;
        }

        /**
         * count of error corrected packets 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2
        )
        public final Builder fixed(int fixed) {
            this.fixed = fixed;
            return this;
        }

        /**
         * local signal strength 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder rssi(int rssi) {
            this.rssi = rssi;
            return this;
        }

        /**
         * remote signal strength 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder remrssi(int remrssi) {
            this.remrssi = remrssi;
            return this;
        }

        /**
         * how full the tx buffer is as a percentage 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder txbuf(int txbuf) {
            this.txbuf = txbuf;
            return this;
        }

        /**
         * background noise level 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder noise(int noise) {
            this.noise = noise;
            return this;
        }

        /**
         * remote background noise level 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder remnoise(int remnoise) {
            this.remnoise = remnoise;
            return this;
        }

        public final Radio build() {
            return new Radio(rxerrors, fixed, rssi, remrssi, txbuf, noise, remnoise);
        }
    }
}
