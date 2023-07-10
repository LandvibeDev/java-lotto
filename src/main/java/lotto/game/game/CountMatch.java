package lotto.game.game;

import lotto.game.lotto.Lotto;
import lotto.game.result.LottoCount;

import java.util.ArrayList;
import java.util.List;

public interface CountMatch {
    List<LottoCount> countMatchNumber(ArrayList<Integer> winningNumber, Integer bonusNumber, List<Lotto>LottoList);
    int countMatchReward(List<LottoCount>lottoCountList);
}
