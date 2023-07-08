package lotto;

import lotto.number.LottoNumberManager;
import lotto.number.NumberManager;
import lotto.validator.LottoValidator;
import lotto.validator.Validator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator lottoValidator = new LottoValidator();
        NumberManager lottoNumberManager = new LottoNumberManager(lottoValidator);
        GameController lottoGameController = new LottoGameController(lottoNumberManager);

        lottoGameController.play();
    }
}