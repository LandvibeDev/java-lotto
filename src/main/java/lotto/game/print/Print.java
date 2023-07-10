package lotto.game.print;

import lotto.game.lotto.Lotto;
import lotto.game.result.Awards;
import lotto.game.result.Result;
import lotto.game.user.User;

import java.util.List;

public interface Print {
    void printNumberList(List<Lotto> lottoList);

    void printResultStart();

    void printResult(Awards awards, Result result);

    void printRateOfReturn(Integer purchaseMoney, User user);

    void printPurchaseCount(int cnt);
}
