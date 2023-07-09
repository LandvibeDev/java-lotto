package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Rule.*;

public class RandomNumberGenerator {

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START, END, COUNT);
        return randomNumbers;
    }
}
