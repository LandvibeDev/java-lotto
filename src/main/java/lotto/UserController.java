package lotto;

import static lotto.SettingValues.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class UserController implements Machine {

	Validator validator;
	Lotto winningLotto;
	List<Lotto> userLottos;
	int bonusNum;
	long purchaseAmount;
	int[] rankings;
	int[] rewards;
	long totalReward;
	AutoLottoMachine autoLottoMachine;
	LottoCompareMachine compareMachine;

	UserController() {
		rankings = new int[6];
		userLottos = new ArrayList<>();
		autoLottoMachine = new AutoLottoMachine();
		validator = new Validator();
		compareMachine = new LottoCompareMachine();
	}

	@Override
	public void run(){
		purchaseLotto();
		compareMachine.run();
		winningLotto = compareMachine.getWinningLotto();
		bonusNum = compareMachine.getBonusNum();
		checkUserLotto();
		printResult();
	}


	public void purchaseLotto() {
		System.out.println("구입금액을 입력해 주세요.");
		String inStr = Console.readLine();
		if (validator.isNotInteger(inStr)) {
			throw new IllegalArgumentException("[ERROR]");
		}
		purchaseAmount = Long.parseLong(inStr);
		if (purchaseAmount % PRICE_OF_LOTTO.get() != 0) {
			throw new IllegalArgumentException("[ERROR]");
		}
		int numOfLotto = (int)(purchaseAmount / 1000L);

		System.out.println(numOfLotto + "개를 구매했습니다.");
		for (int i = 0; i < numOfLotto; i++) {
			autoLottoMachine.run();
			Lotto lotto = autoLottoMachine.getAutoLotto();
			userLottos.add(lotto);
		}
	}

	public void checkUserLotto() {
		int winPoint;
		int ranking;
		for (Lotto lotto : userLottos) {
			winPoint = compareMachine.compare(lotto);
			ranking = rank(winPoint);
			totalReward += rewards[ranking];
		}
	}


	public int rank(int winPoint) {
		int ranking = 8 - winPoint;
		if (ranking <= 5) {
			rankings[ranking]++;
			return ranking;
		}
		return 0;
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
	public List<Lotto> getUserLottos(){
		return userLottos;
	}

}
