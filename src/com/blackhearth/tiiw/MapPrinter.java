package com.blackhearth.tiiw;

import java.util.Map;

public class MapPrinter {
    public static void printMap(Map<Character, Integer> map) {
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
