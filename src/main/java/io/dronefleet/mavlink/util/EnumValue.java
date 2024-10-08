package io.dronefleet.mavlink.util;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.util.reflection.MavlinkReflection;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EnumValue<T extends Enum<T>> {

    private final int value;
    private final T entry;
    private final Class<?> entryClass;

    private EnumValue(int value, T entry) {
        this.value = value;
        this.entry = entry;
        this.entryClass = entry != null ? entry.getClass() : null;
    }

    private EnumValue(int value, T entry, Class<?> entryClass) {
        this.value = value;
        this.entry = entry;
        this.entryClass = entryClass;
    }

    public static  boolean isBitmask(Class<?> entryClass) {
        MavlinkEnum annotation = entryClass.getAnnotation(MavlinkEnum.class);
        return annotation != null && annotation.bitmask();
    }

    public static <T extends Enum<T>> EnumValue<T> of(T entry) {
        int value = MavlinkReflection.getEnumValue(entry);
        return new EnumValue<>(value, entry);
    }

    @SafeVarargs
    public static <T extends Enum<T>> EnumValue<T> create(Enum<T>... flags) {
        return create(Arrays.asList(flags));
    }

    public static <T extends Enum<T>> EnumValue<T> create(Collection<Enum<T>> flags) {
        return create((Class<T>)flags.stream()
                .map(Enum::getClass)
                .findFirst()
                .orElse(null),
                flags.stream()
                .mapToInt(MavlinkReflection::getEnumValue)
                .reduce((bitmask, value) -> bitmask | value)
                .orElse(0));

    }

    public static <T extends Enum<T>> EnumValue<T> create(int value) {
        return new EnumValue<>(value, null);
    }

    public static <T extends Enum<T>> EnumValue<T> create(Class<T> enumType, int value) {
        return new EnumValue<>(
                value,
                MavlinkReflection.getEntryByValue(enumType, value)
                        .orElse(null), enumType);
    }

    public static <T extends Enum<T>> List<T> decompose(EnumValue<T> value) {
        if(!isBitmask(value.getEntryClass())) {
            throw new IllegalArgumentException("Enum type is not a bitmask");
        }

        List<T> allEntries = MavlinkReflection.getEntries((Class<T>)value.getEntryClass());
        return allEntries.stream()
                .filter(entry -> {
                    int entryValue = MavlinkReflection.getEnumValue(entry);
                    return (value.value & entryValue) == entryValue;
                })
                .collect(Collectors.toList());
    }

    public boolean flagsEnabled(Enum<T>... flags) {
        return flagsEnabled(Arrays.stream(flags)
                .map(MavlinkReflection::getEnumValue)
                .mapToInt(Integer::intValue)
                .toArray());
    }

    public boolean flagsEnabled(int... flags) {
        return Arrays.stream(flags)
                .filter(flag -> flag != (value & flag))
                .mapToObj(flag -> false)
                .findFirst()
                .orElse(true);
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

        EnumValue<?> enumValue = (EnumValue<?>) o;

        if (value != enumValue.value) {
            return false;
        }
        return Objects.equals(entry, enumValue.entry);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MessageFormat.format("EnumValue'{'value={0}, entry={1}'}'", value, entry);
    }
    //endregion

    //region Description
    public int value() {
        return value;
    }

    public T entry() {
        return entry;
    }

    public Class<?> getEntryClass() {
        return entryClass;
    }

    //endregion

}
