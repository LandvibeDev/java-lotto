package lotto;

import lotto.number.LottoNumberManager;
import lotto.number.NumberManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberManager numberManager = new LottoNumberManager();
        GameController lottoGameController = new LottoGameController(numberManager);

        lottoGameController.play();
    }
}