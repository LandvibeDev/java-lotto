package lotto.game.game;

import lotto.game.lotto.Lotto;
import lotto.game.lotto.LottoCount;

import java.util.List;

public interface CountMatch {
    LottoCount countMatchNumber(List<Integer> winningNumber, Integer bonusNumber, Lotto lotto);
    int countMatchReward(LottoCount lottoCount);
}
