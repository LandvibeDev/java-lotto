package lotto.game.game;

import java.util.ArrayList;
import java.util.List;

public interface CountMatch {
    void countMatchNumber(ArrayList<Integer> winningNumber, Integer bonusNumber, List<Integer> lottoNumber);

    void countMatchRefund(int cnt, int bonusCnt);

}
