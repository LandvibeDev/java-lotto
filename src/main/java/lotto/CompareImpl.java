package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constant.*;

public class CompareImpl implements Compare {

    private final List<Integer> input;
    private final List<Integer> randomNumber;

    CompareImpl(List<Integer> input, List<Integer> randomNumber) {
        this.input = input;
        this.randomNumber = randomNumber;
    }

    @Override
    public List<Integer> compare() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < DIGITS; i++) {
            Integer a = input.get(i);
            if (randomNumber.contains(a)) {
                result.add(1);
            }
        }
        if (randomNumber.contains(input.get(DIGITS))) {
            result.add(2);
        }
        return result;
    }

    @Override
    public int[] winCount(List<Integer> list) {
        int[] result = new int[2];
        result[0] = Collections.frequency(list, 1);
        result[1] = Collections.frequency(list, 2);
        return result;
    }
}
