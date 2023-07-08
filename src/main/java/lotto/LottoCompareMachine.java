package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class LottoCompareMachine implements Machine{
	private Lotto winningLotto;
	private Integer bonusNum;
	Validator validator;
	LottoCompareMachine(){
		validator = new Validator();
	}
	@Override
	public void run(){
		winningLotto = new Lotto(inputWinningNumbers());
		bonusNum = inputBonusNum();
	}
	public List<Integer> inputWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		List<Integer> winningNums = new ArrayList<Integer>();
		String inStr = Console.readLine();
		StringTokenizer tokenizedInStr = new StringTokenizer(inStr, ",");
		while (tokenizedInStr.hasMoreTokens()) {
			String nextNum = tokenizedInStr.nextToken();
			if (validator.isNotInteger(nextNum)) {
				throw new IllegalArgumentException("[ERROR]");
			}
			Integer cur = Integer.parseInt(nextNum);
			winningNums.add(cur);
		}
		return winningNums;
	}
	public int inputBonusNum() {
		int bonusNum;
		System.out.println("보너스 번호를 입력해 주세요.");
		String inStr = Console.readLine();
		if (validator.isNotInteger(inStr)) {
			throw new IllegalArgumentException("[ERROR]");

		}
		bonusNum = Integer.parseInt(inStr);
		List<Integer> winningNums = getWinningLotto().getLottoNums();
		if (winningNums.contains(bonusNum)) {
			throw new IllegalArgumentException("[ERROR]");
		}
		return bonusNum;
	}
	public int compare(Lotto userLotto) {
		int winPoint = 0;
		List<Integer> userNums = userLotto.getLottoNums();
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
