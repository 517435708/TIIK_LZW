package com.blackhearth.tiiw;

import java.io.File;
import java.util.List;
import java.util.Map;

public class EntryPoint {

    public static void main(String[] args) {

        File itText = new File("it.txt");
        File polishText = new File("pan_tadeusz.txt");
        File englishText = new File("english.txt");

        Map<Character, Integer> countItMap = Counter.count(itText);
        Map<Character, Integer> countPolishMap = Counter.count(polishText);
        Map<Character, Integer> countEnglishMap = Counter.count(englishText);

        MapMerger.merge(countItMap, countPolishMap, countEnglishMap);

        List<CharacterMetaData> polishCharacters = CharacterMetaData.mapFromMap(countPolishMap);
        List<CharacterMetaData> englishCharacters = CharacterMetaData.mapFromMap(countEnglishMap);
        List<CharacterMetaData> itCharacters = CharacterMetaData.mapFromMap(countItMap);

        System.out.println("polish text");
        MapPrinter.printListFormatable(polishCharacters);
        System.out.println("english text");
        MapPrinter.printListFormatable(englishCharacters);
        System.out.println("it text");
        MapPrinter.printListFormatable(itCharacters);


    }
}
