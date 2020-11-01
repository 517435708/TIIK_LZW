package com.blackhearth.tiiw;

import java.util.Map;
import java.util.stream.Collectors;

public class EntropyCalculator {
    public static Double calculateEntropyFor(Map<Character, Double> probabilityMap) {
        return -probabilityMap.values()
                              .stream()
                              .mapToDouble(aDouble -> aDouble * Math.log(1 / aDouble))
                              .sum();
    }

    public static Map<Character, Double> doSomething(Map<Character, Double> probabilityMap) {
        return probabilityMap.entrySet()
                             .stream()
                             .collect(Collectors.toMap(Map.Entry::getKey,
                                                       e -> -Math.log(e.getValue() / (1 - e.getValue()))));
    }
}
