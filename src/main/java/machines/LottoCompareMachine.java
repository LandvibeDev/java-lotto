package machines;

import static config.LottoConfig.*;
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
		winningNums = new ArrayList<Integer>();
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

		validator.handleException(validator.isThereSpace(inStr), NO_SPACE_MESSAGE.get());

		StringTokenizer tokenizedInStr = new StringTokenizer(inStr, getDELIM());

		while (tokenizedInStr.hasMoreTokens()) {
			String nextNum = tokenizedInStr.nextToken();

			validator.handleException(validator.isNotInteger(nextNum), ONLY_INTEGER_MESSAGE.get());

			Integer cur = Integer.parseInt(nextNum);

			validator.handleException(validator.isDuplicatedNum(winningNums,cur), ALREADY_DRAWN_MESSAGE.get());

			winningNums.add(cur);
		}

	}

	public int inputBonusNum() {
		int bonusNum;
		printer.printInputBonusNumMessage();
		String inStr = Console.readLine();

		validator.handleException(validator.isNotInteger(inStr), ONLY_INTEGER_MESSAGE.get());

		bonusNum = Integer.parseInt(inStr);
		List<Integer> winningNums = getWinningLotto().getLottoNums();

		validator.handleException(validator.isDuplicatedNum(winningNums,bonusNum), ALREADY_DRAWN_MESSAGE.get());

		return bonusNum;
	}

	public int compare(List<Integer> userNums) {
		int winPoint = 0;
		List<Integer> winningNums = getWinningLotto().getLottoNums();
		for (Integer cur : winningNums) {
			if (userNums.contains(cur)) {
				winPoint++;
			}
		}
		if (winPoint == 6)
			return 7;
		if (winPoint == 5 && userNums.contains(getBonusNum()))
			return 6;
		return winPoint;
	}

	public Lotto getWinningLotto() {
		return winningLotto;
	}

	public Integer getBonusNum() {
		return bonusNum;
	}
}
