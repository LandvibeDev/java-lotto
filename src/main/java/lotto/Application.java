package lotto;

import lotto.game.Game;
import lotto.game.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game lottoGame = new LottoGame();
        lottoGame.play();
    }
}