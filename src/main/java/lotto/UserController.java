package lotto;

import static lotto.SettingValues.*;
import static lotto.SharingVariables.*;

import camp.nextstep.edu.missionutils.Console;

public class UserController implements Machine {

	Validator validator;
	long purchaseAmount;
	long totalReward;
	AutoLottoMachine autoLottoMachine;
	RewardMeasuringMachine rewardMeasuringMachine;
	Printer printer;

	UserController() {
		validator = new Validator();
		printer = new Printer();
		autoLottoMachine = new AutoLottoMachine();
		rewardMeasuringMachine = new RewardMeasuringMachine();
	}

	@Override
	public void run() {
		purchaseLotto();
		rewardMeasuringMachine.run();
		totalReward = rewardMeasuringMachine.getTotalReward();
		printer.printResult((double)totalReward, (double)purchaseAmount);
	}

	public void purchaseLotto() {
		printer.printInputPurchaseAmountMessage();
		String inStr = Console.readLine();
		if (validator.isNotInteger(inStr)) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요");
		}
		purchaseAmount = Long.parseLong(inStr);
		if (purchaseAmount % PRICE_OF_LOTTO.get() != 0) {
			throw new IllegalArgumentException("[ERROR]");
		}
		int numOfLotto = (int)(purchaseAmount / UNIT_OF_PURCHASE);
		printer.printNumberOfPurchaseMessage(numOfLotto);
		for (int i = 0; i < numOfLotto; i++) {
			autoLottoMachine.run();
			Lotto lotto = autoLottoMachine.getAutoLotto();
			userLottos.add(lotto);
		}
	}

}
