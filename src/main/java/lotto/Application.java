package lotto;

import game.NumberGame;

public class Application {
	public static void main(String[] args) {
		Rule lottoGameRule = new Rule(1, 45, 6);
		NumberGame lottoGame = new LottoGame(lottoGameRule);
		lottoGame.play();
	}
}

