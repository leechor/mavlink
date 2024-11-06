package io.dronefleet.mavlink.util;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;

import java.util.Comparator;

public class WireFieldInfoComparator implements Comparator<MavlinkFieldInfo> {
    @Override
    public int compare(MavlinkFieldInfo a, MavlinkFieldInfo b) {
        return a.position() - b.position();
    }
}
