package com.blackhearth.tiiw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] args) {
        try {

            Map<Character, Integer> map = new HashMap<>();
            File myObj = new File("pan_tadeusz.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                Map<Character, Integer> charactersInLine = DataInterpreter.countCharacters(myReader.nextLine());
                for (var entrySet : charactersInLine.entrySet()) {
                    map.putIfAbsent(entrySet.getKey(), 0);
                    map.replace(entrySet.getKey(),
                                map.computeIfPresent(entrySet.getKey(), (key, value) -> value + entrySet.getValue()));
                }
            }
            myReader.close();

            MapPrinter.printMap(map);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
