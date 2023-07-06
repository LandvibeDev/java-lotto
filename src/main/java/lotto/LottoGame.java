package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import game.NumberGame;

public class LottoGame implements NumberGame {
	private int purchaseMoney;
	private int lottoCount;
	private List<Lotto> lottoList;
	private Rule lottoGameRule;
	private Lotto winningLotto;
	private int bonusNumber;
	private LottoGameAnalyzer lottoGameAnalyzer;

	public LottoGame(Rule lottoGameRule) {
		purchaseMoney = 0;
		lottoCount = 0;
		lottoList = new ArrayList<>();
		this.lottoGameRule = lottoGameRule;
		winningLotto = new Lotto();
		bonusNumber = 0;
		lottoGameAnalyzer = new LottoGameAnalyzer();
	}

	@Override
	public void play() {
		inputPurchaseMoney();
		calculateLottoCount();
	}

	private void inputPurchaseMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String input = Console.readLine();
		purchaseMoney = Integer.parseInt(input);
	}

	private void calculateLottoCount() {
		lottoCount = purchaseMoney / 1000;
	}
}
