package io.dronefleet.mavlink.generator.definitions.model;

import java.util.List;

public class MavlinkMessageDef {
    private final int id;
    private final String name;
    private final Integer crcExtra;
    private final String description;
    private final List<MavlinkFieldDef> fields;
    private final MavlinkDeprecationDef deprecation;
    private final boolean workInProgress;

    public MavlinkMessageDef(
            int id,
            String name,
            Integer crcExtra,
            String description,
            List<MavlinkFieldDef> fields,
            MavlinkDeprecationDef deprecation,
            boolean workInProgress) {
        this.id = id;
        this.name = name;
        this.crcExtra = crcExtra;
        this.description = description;
        this.fields = fields;
        this.deprecation = deprecation;
        this.workInProgress = workInProgress;
    }

    //region Description
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkMessageDef that = (MavlinkMessageDef) o;

        if (id != that.id) return false;
        if (workInProgress != that.workInProgress) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (fields != null ? !fields.equals(that.fields) : that.fields != null) return false;
        return deprecation != null ? deprecation.equals(that.deprecation) : that.deprecation == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        result = 31 * result + (deprecation != null ? deprecation.hashCode() : 0);
        result = 31 * result + (workInProgress ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MavlinkMessageDef{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fields=" + fields +
                ", deprecation=" + deprecation +
                ", workInProgress=" + workInProgress +
                '}';
    }
    //endregion

    //region Description
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCrcExtra() {
        return crcExtra;
    }

    public String getDescription() {
        return description;
    }

    public List<MavlinkFieldDef> getFields() {
        return fields;
    }

    public MavlinkDeprecationDef getDeprecation() {
        return deprecation;
    }

    public boolean isWorkInProgress() {
        return workInProgress;
    }
    //endregion

}
