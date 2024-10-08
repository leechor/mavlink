package io.dronefleet.mavlink.util.reflection;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MavlinkReflection {
    private MavlinkReflection() {
    }

    public static int getEnumValue(Enum<?> entry) {
        return getEnumEntry(entry)
                .orElseThrow(() -> new IllegalArgumentException(
                        "The specified entry is not annotated with @MavlinkEntryInfo"))
                .value();
    }

    public static Optional<MavlinkEntryInfo> getEnumEntry(Enum<?> entry) {
        return Arrays.stream(entry.getDeclaringClass().getFields())
                .filter(Field::isEnumConstant)
                .filter(f -> f.isAnnotationPresent(MavlinkEntryInfo.class))
                .filter(f -> {
                    try {
                        return entry.equals(f.get(null));
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                })
                .findFirst()
                .map(f -> f.getAnnotation(MavlinkEntryInfo.class));
    }

    public static <T extends Enum<?>> Optional<T> getEntryByValue(Class<T> enumType, int value) {
        if (enumType == null) {
            return Optional.empty();
        }

        return Arrays.stream(enumType.getFields())
                .filter(Field::isEnumConstant)
                .filter(f -> f.isAnnotationPresent(MavlinkEntryInfo.class))
                .filter(f -> f.getAnnotation(MavlinkEntryInfo.class).value() == value)
                .map(f -> {
                    try {
                        return f.get(null);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                })
                .map(enumType::cast)
                .findFirst();
    }

    public static <T extends Enum<?>> List<T> getEntries(Class<T> enumType) {
        return Arrays.stream(enumType.getFields())
                .filter(Field::isEnumConstant)
                .filter(f -> f.isAnnotationPresent(MavlinkEntryInfo.class))
                .map(f -> {
                    try {
                        return f.get(null);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                })
                .map(enumType::cast)
                .collect(Collectors.toList());
    }

    public static boolean isMavlinkMessage(Object o) {
        return getMessageInfo(o).isPresent();
    }

    public static Optional<MavlinkMessageInfo> getMessageInfo(Object message) {
        return Optional.ofNullable(message.getClass().getAnnotation(MavlinkMessageInfo.class));
    }
}
