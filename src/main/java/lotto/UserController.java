package lotto;

import static lotto.SettingValues.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class UserController implements Machine {

	Lotto winningLotto;
	List<Lotto> userLottos;
	int bonusNum;
	long purchaseAmount;
	int[] rankings;
	int[] rewards;
	long totalReward;
	AutoLottoMachine autoLottoMachine;

	UserController() {
		rankings = new int[6];
		rewards = new int[] {0, 2000000000, 30000000, 1500000, 50000, 5000};
		userLottos = new ArrayList<>();
		autoLottoMachine = new AutoLottoMachine();
	}

	@Override
	public void run(){
		autoLottoMachine.run();
		purchaseLotto();
		List<Integer> winningNums = inputWinningNumbers();
		winningLotto = new Lotto(winningNums);
		inputBonusNum();
		checkUserLotto();
		printResult();
	}
	public List<Integer> inputWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		List<Integer> winningNums = new ArrayList<Integer>();
		String inStr = Console.readLine();
		StringTokenizer tokenizedInStr = new StringTokenizer(inStr, ",");
		while (tokenizedInStr.hasMoreTokens()) {
			String nextNum = tokenizedInStr.nextToken();
			if (isNotInteger(nextNum)) {
				throw new IllegalArgumentException("[ERROR]");
			}
			Integer cur = Integer.parseInt(nextNum);
			winningNums.add(cur);
		}
		return winningNums;
	}

	public void inputBonusNum() {
		System.out.println("보너스 번호를 입력해 주세요.");
		String inStr = Console.readLine();
		if (isNotInteger(inStr)) {
			throw new IllegalArgumentException("[ERROR]");

		}
		bonusNum = Integer.parseInt(inStr);
		List<Integer> winningNums = winningLotto.getLottoNums();
		if (winningNums.contains(bonusNum)) {
			throw new IllegalArgumentException("[ERROR]");
		}
	}



	public void purchaseLotto() {
		System.out.println("구입금액을 입력해 주세요.");
		String inStr = Console.readLine();
		if (isNotInteger(inStr)) {
			throw new IllegalArgumentException("[ERROR]");
		}
		purchaseAmount = Long.parseLong(inStr);
		if (purchaseAmount % PRICE_OF_LOTTO.get() != 0) {
			throw new IllegalArgumentException("[ERROR]");
		}
		int numOfLotto = (int)(purchaseAmount / 1000L);

		System.out.println(numOfLotto + "개를 구매했습니다.");
		for (int i = 0; i < numOfLotto; i++) {
			Lotto lotto = autoLottoMachine.getAutoLotto();
			userLottos.add(lotto);
		}
	}

	public void checkUserLotto() {
		int winPoint;
		int ranking;
		for (Lotto lotto : userLottos) {
			winPoint = compare(lotto);
			ranking = rank(winPoint);
			totalReward += rewards[ranking];
		}
	}

	public int compare(Lotto userLotto) {
		int winPoint = 0;
		List<Integer> userNums = userLotto.getLottoNums();
		List<Integer> winningNums = winningLotto.getLottoNums();
		for (Integer cur : winningNums) {
			if (userNums.contains(cur)) {
				winPoint++;
			}
		}
		if (winPoint == 6)
			return 7;
		if (winPoint == 5 && userNums.contains(bonusNum))
			return 6;
		return winPoint;
	}

	public int rank(int winPoint) {
		int ranking = 8 - winPoint;
		if (ranking <= 5) {
			rankings[ranking]++;
			return ranking;
		}
		return 0;
	}

	public boolean isNotInteger(String inStr) {
		for (char c : inStr.toCharArray()) {
			if (c < '0' || c > '9')
				return true;
		}
		return false;
	}

	public void printResult() {
		double profitRatio = 0;
		System.out.println("당첨 통계\n" + "---");
		System.out.print("3개 일치 (5,000원) - ");
		System.out.println(rankings[5] + "개");
		System.out.print("4개 일치 (50,000원) - ");
		System.out.println(rankings[4] + "개");
		System.out.print("5개 일치 (1,500,000원) - ");
		System.out.println(rankings[3] + "개");
		System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
		System.out.println(rankings[2] + "개");
		System.out.print("6개 일치 (2,000,000,000원) - ");
		System.out.println(rankings[1] + "개");
		profitRatio = ((double)totalReward / (double)purchaseAmount) * 100.0;
		System.out.printf("총 수익률은 %.1f", profitRatio);
		System.out.println("%입니다.");

	}

}
