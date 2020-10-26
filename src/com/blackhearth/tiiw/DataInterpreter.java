package com.blackhearth.tiiw;

import java.util.HashMap;
import java.util.Map;

public class DataInterpreter {
    public static Map<Character, Integer> countCharacters(String nextLine) {
        Map<Character, Integer> map = new HashMap<>();

        for (var character : nextLine.toCharArray()) {
            map.putIfAbsent(character, 0);
            map.replace(character, map.get(character) + 1);
        }
        return map;
    }
}
