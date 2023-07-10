package lotto.game.print;

import lotto.game.lotto.Lotto;
import lotto.game.result.LottoCount;

import java.util.List;

public interface Print {
    void printNumberList(List<Lotto> lottoList);

    void printResultStart();

    void printResult(List<LottoCount>lottoCountList);

    void printRateOfReturn(Integer purchaseMoney, Integer rewards);

    void printPurchaseCount(int cnt);
}
