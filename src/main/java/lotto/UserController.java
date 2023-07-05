package lotto;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class UserController {

	Lotto winningLotto;


	UserController() {
		List<Integer> winningNums = inputWinningNumbers();
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
		for (int a : winningNums) { // debug
			System.out.println(a);
		}
		return winningNums;
	}

	public Lotto purchaseALotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		Lotto lotto = new Lotto(numbers);
		return lotto;
	}

	public void purchaseLotto(int numOfLotto) {
		int winPoint = 0;
		for (int i = 0; i < numOfLotto; i++) {
			Lotto lotto = purchaseALotto();
			winPoint = compare(lotto);
		}
	}

	public int compare(Lotto lotto) {
		int winPoint = 0;
		List<Integer> userNums = lotto.getLottoNums();
		for (Integer cur : userNums){
			if(winningLotto.getLottoNums().contains(cur)){
				winPoint++;
			}
		}
		return winPoint;
	}

}
