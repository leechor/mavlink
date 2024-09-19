package io.dronefleet.mavlink.generator.definitions.model;

import java.text.MessageFormat;
import java.util.List;

public class MavlinkEntryDef {
    private final Integer value;
    private final String name;
    private final String description;
    private final List<MavlinkParamDef> params;
    private final MavlinkDeprecationDef deprecation;

    public MavlinkEntryDef(Integer value, String name, String description, List<MavlinkParamDef> params, MavlinkDeprecationDef deprecation) {
        this.value = value;
        this.name = name;
        this.description = description;
        this.params = params;
        this.deprecation = deprecation;
    }

    //region Description
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkEntryDef that = (MavlinkEntryDef) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (params != null ? !params.equals(that.params) : that.params != null) return false;
        return deprecation != null ? deprecation.equals(that.deprecation) : that.deprecation == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (params != null ? params.hashCode() : 0);
        result = 31 * result + (deprecation != null ? deprecation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MessageFormat.format("MavlinkEntryDef'{'value={0}, name=''{1}'', description=''{2}'', params={3}, deprecation={4}'}'", value, name, description, params, deprecation);
    }
    //endregion

    //region Description
    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<MavlinkParamDef> getParams() {
        return params;
    }

    public MavlinkDeprecationDef getDeprecation() {
        return deprecation;
    }
    //endregion

}
