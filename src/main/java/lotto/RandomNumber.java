package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.Constant.*;


public class RandomNumber {
    public List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_BOUND, MAX_BOUND, DIGITS));
        Collections.sort(randomNumber);
        System.out.println(randomNumber);
        return randomNumber;
    }
}
