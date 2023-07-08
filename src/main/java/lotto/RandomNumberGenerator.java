package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static lotto.Rule.*;

public class RandomNumberGenerator {

    public ArrayList<Integer> generateRandomNumbers() {
        Set<Integer> numberSet = new HashSet<>();
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        while (numberSet.size() < COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START, END);
            if (numberSet.contains(randomNumber)) {
                continue;
            }
            randomNumbers.add(randomNumber);
            numberSet.add(randomNumber);
        }
        return randomNumbers;
    }
}
