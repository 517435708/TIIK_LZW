package com.blackhearth.tiiw;

import java.util.Map;

public class MapMerger {
    public static void merge(Map<Character, Integer> firstMap,
                             Map<Character, Integer> secondMap,
                             Map<Character, Integer> thirdMap) {

        for (var key : firstMap.keySet()) {
            secondMap.putIfAbsent(key, 0);
            thirdMap.putIfAbsent(key, 0);
        }

        for (var key : secondMap.keySet()) {
            firstMap.putIfAbsent(key, 0);
            thirdMap.putIfAbsent(key, 0);
        }

        for (var key : thirdMap.keySet()) {
            firstMap.putIfAbsent(key, 0);
            secondMap.putIfAbsent(key, 0);
        }
    }
}
