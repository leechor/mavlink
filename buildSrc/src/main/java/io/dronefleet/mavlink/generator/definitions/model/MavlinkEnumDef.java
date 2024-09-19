package io.dronefleet.mavlink.generator.definitions.model;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

public class MavlinkEnumDef {
    private final String name;
    private final String description;
    private final List<MavlinkEntryDef> entries;
    private final MavlinkDeprecationDef deprecation;
    private final boolean bitmask;

    public MavlinkEnumDef(String name, String description, List<MavlinkEntryDef> entries, MavlinkDeprecationDef deprecation, boolean bitmask) {
        this.name = name;
        this.description = description;
        this.entries = entries;
        this.deprecation = deprecation;
        this.bitmask = bitmask;
    }

    //region Description
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MavlinkEnumDef that = (MavlinkEnumDef) o;

        if (!Objects.equals(name, that.name)) {
            return false;
        }
        if (!Objects.equals(description, that.description)) {
            return false;
        }
        if (!Objects.equals(entries, that.entries)) {
            return false;
        }
        return Objects.equals(deprecation, that.deprecation);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (entries != null ? entries.hashCode() : 0);
        result = 31 * result + (deprecation != null ? deprecation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MessageFormat.format("MavlinkEnumDef'{'name=''{0}'', description=''{1}'', entries={2}, deprecation={3}'', bitmask={4}'}'", name, description, entries, deprecation, bitmask);
    }
    //endregion

    //region Description
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<MavlinkEntryDef> getEntries() {
        return entries;
    }

    public MavlinkDeprecationDef getDeprecation() {
        return deprecation;
    }

    public boolean isBitmask() {
        return bitmask;
    }
    //endregion

}
