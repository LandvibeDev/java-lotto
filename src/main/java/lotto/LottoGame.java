package lotto;

import static lotto.Constant.Rule.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import game.NumberGame;
import lotto.Constant.Format;

public class LottoGame implements NumberGame {
	private int purchaseMoney;
	private int lottoCount;
	private List<Lotto> lottoList;
	private Rule lottoGameRule;
	private Lotto winningLotto;
	private int bonusNumber;
	private LottoGameAnalyzer lottoGameAnalyzer;
	private Validator validator;
	private View view;

	public LottoGame(Rule lottoGameRule) {
		this.lottoGameRule = lottoGameRule;

		purchaseMoney = ZERO.get();
		lottoCount = ZERO.get();
		bonusNumber = ZERO.get();

		lottoList = new ArrayList<>();
		winningLotto = new Lotto();
		lottoGameAnalyzer = new LottoGameAnalyzer();
		validator = new Validator();
		view = new View();
	}

	@Override
	public void play() {
		try {
			inputPurchaseMoney();
			calculateLottoCount();
			issueLotto();
			view.printIssuedLottoList(lottoCount, lottoList);
			inputWinningLotto();
			inputBonusNumber();
			lottoGameAnalyzer.analyze(winningLotto, bonusNumber, lottoList, purchaseMoney);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void inputPurchaseMoney() {
		view.printRequestPurchaseMoney();
		String input = Console.readLine();
		validator.validatePurchaseMoney(input);
		purchaseMoney = Integer.parseInt(input);
	}

	private void calculateLottoCount() {
		lottoCount = purchaseMoney / LOTTO_PRICE.get();
	}

	private void issueLotto() {
		for (int iterator = ZERO.get(); iterator < lottoCount; iterator++) {
			lottoList.add(new Lotto(lottoGameRule));
		}
	}

	private void inputWinningLotto() {
		view.printRequestWinningLotto();
		String input = Console.readLine();
		validator.validateWinningLotto(input);

		List<Integer> winningNumbers = Arrays.stream(input.split(Format.REGEX.get()))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		winningLotto = new Lotto(winningNumbers);
	}

	private void inputBonusNumber() {
		view.printRequestBonusNumber();
		String input = Console.readLine();
		validator.validateBonusNumber(input);
		bonusNumber = Integer.parseInt(input);
	}
}
