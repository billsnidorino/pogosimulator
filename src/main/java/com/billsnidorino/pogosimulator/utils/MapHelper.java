package com.billsnidorino.pogosimulator.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class MapHelper {

    // TODO: Add size assertion here?
    public static <E, F> F getDefaultMapValue(final Map<E, F> map) {
        return map.entrySet().iterator().next().getValue();
    }

    public static <E, F> E getDefaultMapKey(final Map<E, F> map) {
        return map.entrySet().iterator().next().getKey();
    }

    public static <E, F> List<E> getKeyListFromMap(final Map<E, F> map) {
        return map.keySet().stream().collect(Collectors.toList());
    }

    public static <E, F> List<F> getValueListFromMap(final Map<E, F> map) {
        return map.values().stream().collect(Collectors.toList());
    }
}
