package lotto;

import static lotto.Result.*;
import static lotto.Rule.COUNT;

public class MatchedNumbers {
    int bonusNumberMatching;
    int mainNumberMatching;

    public Result computeResult() {
        int sum = mainNumberMatching + bonusNumberMatching;
        if (sum == COUNT) {
            if (bonusNumberMatching == 0) {
                return FIRST;
            }
            return SECOND;
        } else if (sum < COUNT) {
            if (sum == COUNT - 1) {
                return THIRD;
            } else if (sum == COUNT - 2) {
                return FOURTH;
            } else if (sum == COUNT - 3) {
                return FIFTH;
            }
        }
        return NONE;
    }
}
