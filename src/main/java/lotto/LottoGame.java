package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	private Validator validator;

	public LottoGame(Rule lottoGameRule) {
		purchaseMoney = 0;
		lottoCount = 0;
		lottoList = new ArrayList<>();
		this.lottoGameRule = lottoGameRule;
		winningLotto = new Lotto();
		bonusNumber = 0;
		lottoGameAnalyzer = new LottoGameAnalyzer();
		validator = new Validator();
	}

	@Override
	public void play() {
		try {
			inputPurchaseMoney();
			calculateLottoCount();
			issueLotto();
			printIssuedLottoList();
			inputWinningLotto();
			inputBonusNumber();
			lottoGameAnalyzer.analyze(winningLotto, bonusNumber, lottoList, purchaseMoney);
		} catch (IllegalArgumentException exception){
			System.out.println(exception.getMessage());
		}
	}

	private void inputPurchaseMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String input = Console.readLine();
		validator.validatePurchaseMoney(input);
		purchaseMoney = Integer.parseInt(input);
	}

	private void calculateLottoCount() {
		lottoCount = purchaseMoney / 1000;
	}

	private void issueLotto() {
		for (int iterator = 0; iterator < lottoCount; iterator++) {
			lottoList.add(new Lotto(lottoGameRule));
		}
	}

	private void printIssuedLottoList() {
		System.out.println("\n" + lottoCount + "개를 구매했습니다.");
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}

	private void inputWinningLotto() {
		System.out.println("\n당첨 번호를 입력해 주세요.");
		String input = Console.readLine();
		validator.validateWinningLotto(input);

		List<Integer> winningNumbers = Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		winningLotto = new Lotto(winningNumbers);
	}

	private void inputBonusNumber() {
		System.out.println("\n보너스 번호를 입력해 주세요.");
		String input = Console.readLine();
		validator.validateBonusNumber(input);
		bonusNumber = Integer.parseInt(input);
	}
}
