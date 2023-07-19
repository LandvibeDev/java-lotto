package lotto.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.constant.Constant.*;

public class CompareImpl implements Compare {

    private final List<Integer> input;
    private final List<Integer> randomNumber;

    public CompareImpl(List<Integer> input, List<Integer> randomNumber) {
        this.input = input;
        this.randomNumber = randomNumber;
    }

    @Override
    public List<Integer> compare() {
        List<Integer> result;
        int correct = 0;
        int bonus = 0;
        for (int i = 0; i < DIGITS; i++) {
            Integer a = input.get(i);
            if (randomNumber.contains(a)) {
                correct++;
            }
        }
        if (randomNumber.contains(input.get(DIGITS))) {
            bonus++;
        }
        result = new ArrayList<>(Arrays.asList(correct, bonus));
        return result;
    }

    @Override
    public int[] winCount(List<Integer> list) {
        int[] result = new int[2];
        result[MATCH_COUNT_IDX] = Collections.frequency(list, MATCH_NUMBER);
        result[BONUS_MATCH_COUNT_IDX] = Collections.frequency(list, BONUS_MATCH_NUMBER);
        return result;
    }
}
