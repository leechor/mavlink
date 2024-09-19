package io.dronefleet.mavlink.util;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.util.reflection.MavlinkReflection;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class EnumValue<T extends Enum<T>> {

    private final int value;
    private final T entry;
    private final boolean bitmask;

    private EnumValue(int value, T entry) {
        this.value = value;
        this.entry = entry;
        MavlinkEnum annotation = entry.getClass().getAnnotation(MavlinkEnum.class);
        this.bitmask = annotation != null && annotation.bitmask();
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
        return create(flags.stream()
                .mapToInt(MavlinkReflection::getEnumValue)
                .reduce((bitmask, value) -> bitmask | value)
                .orElse(0));
    }

    public static <T extends Enum<T>> EnumValue<T> create(int value) {
        return new EnumValue<>(value, null);
    }

    public static <T extends Enum<T>> EnumValue<T> create(Class<T> enumType, int value) {
        return create(enumType, value, false);
    }

    public static <T extends Enum<T>> EnumValue<T> create(Class<T> enumType, int value, boolean bitmask) {
        return new EnumValue<>(
                value,
                Objects.requireNonNull(MavlinkReflection.getEntryByValue(enumType, value)
                        .orElse(null)));
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


    //region Description
    public int value() {
        return value;
    }

    public T entry() {
        return entry;
    }

    public boolean bitmask() {
        return bitmask;
    }
    //endregion

}
