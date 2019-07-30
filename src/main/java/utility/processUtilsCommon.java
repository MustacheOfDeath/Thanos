package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class processUtilsCommon {
    public static List<String> createRandomList(List<String> listToRandomize) {
        List<String> randomList = new ArrayList<>();
        Random randomGenerator = new Random();
        List<Integer> previousNum = new ArrayList<>();
        do {
            int randomNum = randomGenerator.nextInt(listToRandomize.size());
            if (!previousNum.contains(randomNum)) {
                previousNum.add(randomNum);
                randomList.add(listToRandomize.get(randomNum));
            }
        } while (randomList.size() < (listToRandomize.size() / 2));
        return randomList;
    }
}
