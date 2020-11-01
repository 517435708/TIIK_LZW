package com.blackhearth.tiiw;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CharacterMetaData {
    public Character character;
    public Double probability;
    public Integer count;
    public Double info;

    public CharacterMetaData(Character character, Double probability, Integer count, Double info) {
        this.character = character;
        this.probability = probability;
        this.count = count;
        this.info = info;
    }

    public static List<CharacterMetaData> mapFromMap(Map<Character, Integer> countMap) {
        List<CharacterMetaData> characterMetaData = new ArrayList<>();
        var probability = ProbabilityCalculator.calculateProbability(countMap);
        var info = InfoGainCalculator.infoGainFromCharacter(probability);
        for (var character : countMap.keySet()) {
            characterMetaData.add(new CharacterMetaData(character,
                                                        probability.get(character),
                                                        countMap.get(character),
                                                        info.get(character)));
        }
        return characterMetaData;
    }

}
