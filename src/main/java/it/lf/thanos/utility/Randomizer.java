package it.lf.thanos.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {
    public static List<String> createRandomList(List<String> listToRandomize) {
        List<String> randomList = new ArrayList<>();
        Random randomGenerator = new Random();
        List<Integer> previousNum = new ArrayList<>();
        do {
            int randomNum = randomGenerator.nextInt(listToRandomize.size());
            if ((!previousNum.contains(randomNum)) && !("").equals(listToRandomize.get(randomNum).trim())) {
                previousNum.add(randomNum);
                randomList.add(listToRandomize.get(randomNum));
            }
        } while (randomList.size() < (listToRandomize.size() / 2));
        return randomList;
    }
}
