package io.dronefleet.mavlink.generator.definitions.model;

import java.text.MessageFormat;
import java.util.Objects;

public class MavlinkParamDef {
    private final int index;
    private final String description;

    public MavlinkParamDef(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkParamDef that = (MavlinkParamDef) o;

        if (index != that.index) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MessageFormat.format("MavlinkParamDef'{'index={0}, description=''{1}'''}'", index, description);
    }
}
