package lotto;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class UserController {

	Lotto winningLotto;
	List<Integer> winningNums;
	int winPoint;

	UserController() {
		inputWinningNumbers();
		winningLotto = new Lotto(winningNums);
	}

	public void inputWinningNumbers() {
		winningNums = new ArrayList<Integer>();
		String inStr = Console.readLine();
		StringTokenizer tokenizedInStr = new StringTokenizer(inStr, ",");
		while (tokenizedInStr.hasMoreTokens()) {
			Integer cur = Integer.parseInt(tokenizedInStr.nextToken());
			winningNums.add(cur);
		}
		for (int a : winningNums) { // debug
			System.out.println(a);
		}
	}

	public Lotto purchaseALotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		Lotto lotto = new Lotto(numbers);
		return lotto;
	}


}
