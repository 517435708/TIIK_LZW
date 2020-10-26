package com.blackhearth.tiiw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] args) {
        try {
            int sum=0;
            Map<Character, Integer> map = new HashMap<>();
            File myObj = new File("it.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                Map<Character, Integer> charactersInLine = DataInterpreter.countCharacters(myReader.nextLine());
                for (var entrySet : charactersInLine.entrySet()) {
                    map.putIfAbsent(entrySet.getKey(), 0);
                    map.replace(entrySet.getKey(),
                                map.computeIfPresent(entrySet.getKey(), (key, value) -> value + entrySet.getValue()));
                    sum = sum+ entrySet.getValue();
                }
            }
            myReader.close();
            System.out.println(sum);
            MapPrinter.printMap(map);
            for( Map.Entry<Character,Integer> entry : map.entrySet())
            {
                float z =0;
                z = (float) entry.getValue() / sum;
                System.out.println("Rozklad prawdopodobienstwa dla: " + entry.getKey() + " wynosi: " + z);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
