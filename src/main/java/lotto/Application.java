package lotto;

import lotto.game.game.CountMatch;
import lotto.game.game.LottoCountMatch;
import lotto.game.game.Game;
import lotto.game.game.LottoGame;
import lotto.game.input.Input;
import lotto.game.input.LottoInput;
import lotto.game.print.LottoPrint;
import lotto.game.print.Print;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new LottoInput();
        Print print = new LottoPrint();
        CountMatch countMatch = new LottoCountMatch();

        Game lottoGame = new LottoGame(input, print, countMatch);
        lottoGame.start();
    }
}