package com.blackhearth.tiiw;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MapPrinter {

    public static final String SEPARATOR = ";";

    public static void printMap(Map<Character, Integer> map) {
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void printList(List<CharacterMetaData> characterMetaData) {
        for (var character : characterMetaData) {
            System.out.println("[Character: " + character.character + " probability: " + character.probability + " count: " + character.count + " info: " + character.info + "]");
        }
    }

    public static void printListFormatable(List<CharacterMetaData> characterMetaData) {
        characterMetaData.sort(Comparator.comparingInt(c -> c.character));
        for (var character : characterMetaData) {
            System.out.println(SEPARATOR + character.character + SEPARATOR + character.probability + SEPARATOR + character.count + SEPARATOR + character.info);
        }
    }
}
