package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    public Lotto generate(int min, int max, int size) {
        List<Integer> lottoOneList = Randoms.pickUniqueNumbersInRange(min, max, size);
        return new Lotto(lottoOneList);
    }

    public Score calculate(List<Lotto> myLottoSet, Lotto winnerLotto, int bonusNumber) {
        int threeMatchCount = 0;
        int fourMatchCount = 0;
        int fiveMatchCount = 0;
        int fiveAndBonusMatchCount = 0;
        int sixMatchCount = 0;
        for (Lotto myLottoOneSet : myLottoSet) {
            int matchCount = countNumberOfLottoMatches(myLottoOneSet, winnerLotto);
            boolean isBonusMatch = myLottoOneSet.getNumbers().contains(bonusNumber);
            if (matchCount == 3) {
                threeMatchCount++;
                continue;
            }
            if (matchCount == 4) {
                fourMatchCount++;
                continue;
            }
            if (matchCount == 5) {
                if (isBonusMatch) {
                    fiveAndBonusMatchCount++;
                    continue;
                }
                fiveMatchCount++;
                continue;
            }
            if (matchCount == 6) {
                sixMatchCount++;
            }
        }
        return new Score(threeMatchCount, fourMatchCount,
                fiveMatchCount, fiveAndBonusMatchCount, sixMatchCount);
    }

    private int countNumberOfLottoMatches(Lotto myLottoOneSet, Lotto winnerLotto) {
        int matchCount = 0;
        for (int number : myLottoOneSet.getNumbers()) {
            if (winnerLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
