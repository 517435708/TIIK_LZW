package com.blackhearth.tiiw;

import java.util.Map;
import java.util.stream.Collectors;

public class InfoGainCalculator {
    public static Map<Character, Double> infoGainFromCharacter(Map<Character, Double> probabilityMap) {
        return probabilityMap.entrySet()
                             .stream()
                             .collect(Collectors.toMap(Map.Entry::getKey, e -> Math.log(1 / e.getValue())));
    }
}
