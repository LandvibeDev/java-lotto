package lotto;

import static lotto.Constant.Rule.*;

import game.NumberGame;

public class Application {
	public static void main(String[] args) {
		Rule lottoGameRule = new Rule(START_NUMBER.get(), END_NUMBER.get(), NUMBER_SIZE.get());
		NumberGame lottoGame = new LottoGame(lottoGameRule);
		lottoGame.play();
	}
}

