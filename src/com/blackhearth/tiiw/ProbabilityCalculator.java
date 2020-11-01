package com.blackhearth.tiiw;

import java.util.Map;
import java.util.stream.Collectors;

public class ProbabilityCalculator {


    public static Map<Character, Double> calculateProbability(Map<Character, Integer> characterByCount) {
        Integer size = characterByCount.values().stream().mapToInt(Integer::intValue).sum();
        return calculateProbability(characterByCount, size);
    }
    private static Map<Character, Double> calculateProbability(Map<Character, Integer> characterByCount, Integer size) {
        return characterByCount.entrySet()
                               .stream()
                               .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() / (double) size));
    }

    public static Double sum(Map<Character, Double> probabilityMap) {
        return probabilityMap.values().stream().mapToDouble(e -> e).sum();
    }
}
