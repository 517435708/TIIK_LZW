package com.blackhearth.tiiw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Counter {

    public static Map<Character, Integer> count(File file) {
        Map<Character, Integer> countMap = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Map<Character, Integer> charactersInLine = DataInterpreter.countCharacters(scanner.nextLine());
                for (var entrySet : charactersInLine.entrySet()) {
                    countMap.putIfAbsent(entrySet.getKey(), 0);
                    countMap.replace(entrySet.getKey(),
                                     countMap.computeIfPresent(entrySet.getKey(),
                                                               (key, value) -> value + entrySet.getValue()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countMap;
    }

}
