package machines;

import static config.LottoConfig.*;
import static config.SettingValues.*;
import static validate.ErrorMessages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import validate.LottoValidator;
import lotto.Printer;
import machines.interfaces.NumberCompareMachine;

public class LottoCompareMachine implements NumberCompareMachine {
	private Lotto winningLotto;
	private final List<Integer> winningNums;
	private Integer bonusNum;
	LottoValidator validator;
	Printer printer;

	LottoCompareMachine() {
		winningNums = new ArrayList<>();
		validator = new LottoValidator();
		printer = new Printer();
	}

	@Override
	public void run() {
		inputWinningNums();
		winningLotto = new Lotto(winningNums);
		bonusNum = inputBonusNum();
	}

	@Override
	public void inputWinningNums() {
		printer.printInputWinningNumMessage();
		String inStr = Console.readLine();

		try {
			validator.handleException(validator.isThereSpace(inStr), NO_SPACE_MESSAGE.get());
		} catch (IllegalArgumentException e) {
			throw e;
		}

		StringTokenizer tokenizedInStr = new StringTokenizer(inStr, getDELIM());

		while (tokenizedInStr.hasMoreTokens()) {
			String nextNum = tokenizedInStr.nextToken();

			try {
				validator.handleException(validator.isNotInteger(nextNum), ONLY_INTEGER_MESSAGE.get());
			} catch (IllegalArgumentException e) {
				throw e;
			}

			Integer cur = Integer.parseInt(nextNum);

			try {
				validator.handleException(validator.isDuplicatedNum(winningNums, cur), ALREADY_DRAWN_MESSAGE.get());
			} catch (IllegalArgumentException e) {
				throw e;
			}


			winningNums.add(cur);
		}

	}

	public int inputBonusNum() {
		int bonusNum;
		printer.printInputBonusNumMessage();
		String inStr = Console.readLine();

		validator.handleException(validator.isNotInteger(inStr), ONLY_INTEGER_MESSAGE.get());

		bonusNum = Integer.parseInt(inStr);

		validator.handleException(validator.isDuplicatedNum(winningNums, bonusNum), ALREADY_DRAWN_MESSAGE.get());

		return bonusNum;
	}

	public int compare(List<Integer> userNums) {
		int winPoint = ZERO.get();
		List<Integer> winningNums = getWinningLotto().getLottoNums();
		for (Integer cur : winningNums) {
			if (userNums.contains(cur)) {
				winPoint++;
			}
		}
		if (winPoint == POINT_OF_FIRST.get()) {
			return winPoint + EXTRA_POINT.get();
		}
		if (winPoint == POINT_OF_SECOND.get() && userNums.contains(getBonusNum())) {
			return winPoint + EXTRA_POINT.get();
		}
		return winPoint;
	}

	public Lotto getWinningLotto() {
		return winningLotto;
	}

	public Integer getBonusNum() {
		return bonusNum;
	}
}
