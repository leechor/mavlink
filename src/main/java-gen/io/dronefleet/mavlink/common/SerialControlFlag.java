package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * SERIAL_CONTROL flags (bitmask) 
 */
@MavlinkEnum
public enum SerialControlFlag {
    /**
     * Set if this is a reply<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    SERIAL_CONTROL_FLAG_REPLY,

    /**
     * Set if the sender wants the receiver to send a response as another SERIAL_CONTROL message<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    SERIAL_CONTROL_FLAG_RESPOND,

    /**
     * Set if access to the serial port should be removed from whatever driver is currently using it, giving exclusive access to the SERIAL_CONTROL protocol. The port can be handed back by sending a request without this flag set<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    SERIAL_CONTROL_FLAG_EXCLUSIVE,

    /**
     * Block on writes to the serial port<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    SERIAL_CONTROL_FLAG_BLOCKING,

    /**
     * Send multiple replies until port is drained<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    SERIAL_CONTROL_FLAG_MULTI
}
