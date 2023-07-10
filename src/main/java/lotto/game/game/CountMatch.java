package lotto.game.game;

import lotto.game.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public interface CountMatch {
    void countMatchNumber(ArrayList<Integer> winningNumber, Integer bonusNumber, List<Integer> lottoNumber);

    void countMatchRefund(int cnt, int bonusCnt);

    void countLottoResult(ArrayList<Integer> winningNumber, Integer bonusNumber, List<Lotto>lottoList);
}
