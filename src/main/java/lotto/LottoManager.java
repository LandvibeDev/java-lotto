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
}
