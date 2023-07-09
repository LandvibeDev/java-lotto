package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoManager {
    private MyLottoData myLotto;
    private WinnerLottoData winnerLotto;
    private ResultLottoData resultLotto;

    public LottoManager() {
        myLotto = new MyLottoData();
        winnerLotto = new WinnerLottoData();
        resultLotto = new ResultLottoData();
    }

    private void inputPurchaingMoney() {
        System.out.println(Message.Input.PURCHASE_MONEY);
        String input = Console.readLine();
        validatePurchaseMoney(input);
        int money = Integer.parseInt(input);
        myLotto.money = money;
    }

    // TODO: - 유효성 체크
    private void validatePurchaseMoney(String money) {

    }
}
