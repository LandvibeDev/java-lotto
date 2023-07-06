package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class UserController {

	Lotto winningLotto;
	int bonusNum;
	int first;
	int second;
	int third;
	int fourth;
	int fifth;

	UserController() {
		List<Integer> winningNums = inputWinningNumbers();
		inputBonusNum();
		winningLotto = new Lotto(winningNums);
	}

	public List<Integer> inputWinningNumbers() {
		List<Integer> winningNums = new ArrayList<Integer>();
		String inStr = Console.readLine();
		StringTokenizer tokenizedInStr = new StringTokenizer(inStr, ",");
		while (tokenizedInStr.hasMoreTokens()) {
			Integer cur = Integer.parseInt(tokenizedInStr.nextToken());
			winningNums.add(cur);
		}
		return winningNums;
	}

	public void inputBonusNum() {
		String inStr = Console.readLine();
		bonusNum = Integer.parseInt(inStr);
	}

	public Lotto autoLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		Lotto lotto = new Lotto(numbers);
		return lotto;
	}

	public void purchaseLotto(int numOfLotto) {
		int winPoint = 0;
		for (int i = 0; i < numOfLotto; i++) {
			Lotto lotto = autoLotto();
			winPoint = compare(lotto);
		}
	}

	public int compare(Lotto userLotto) {
		int winPoint = 0;
		List<Integer> userNums = userLotto.getLottoNums();
		List<Integer> winningNums = winningLotto.getLottoNums();
		for (Integer cur : winningNums ) {
			if (userNums.contains(cur)) {
				winPoint++;
			}
		}
		if(winPoint == 6) return 7;
		if(winPoint == 5 && userNums.contains(bonusNum)) return 6;
		return winPoint;
	}

}
