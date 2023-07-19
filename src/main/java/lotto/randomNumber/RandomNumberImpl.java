package lotto.randomNumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.constant.Constant.*;


public class RandomNumberImpl implements RandomNumber {
    private static RandomNumberImpl randomNumber;

    private RandomNumberImpl() {
    }

    private static class InstanceHolder {
        private static RandomNumber INSTANCE = new RandomNumberImpl();
    }


    public static RandomNumber getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_BOUND, MAX_BOUND, DIGITS));
        Collections.sort(randomNumber);
        System.out.println(randomNumber);
        return randomNumber;
    }
}
