package lotto;

import static config.LottoConfig.*;
import static lotto.UserValues.*;
import static validate.ErrorMessages.*;

import camp.nextstep.edu.missionutils.Console;

import machines.*;
import machines.interfaces.Machine;

import validate.LottoValidator;

public class UserController implements Machine {

	LottoValidator validator;
	long purchaseAmount;
	long totalReward;
	AutoLottoMachine autoLottoMachine;
	RewardMeasuringMachine rewardMeasuringMachine;
	Printer printer;

	UserController() {
		validator = new LottoValidator();
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

		validator.handleException(validator.isNotInteger(inStr), ONLY_INTEGER_MESSAGE.get());

		purchaseAmount = Long.parseLong(inStr);
		validator.handleException(validator.isInvalidUnit(purchaseAmount), INVALID_UNIT_MESSAGE.get());
		int numOfLotto = (int)(purchaseAmount / getUnitOfPurchase());
		printer.printNumberOfPurchaseMessage(numOfLotto);

		for (int i = 0; i < numOfLotto; i++) {
			autoLottoMachine.run();
			Lotto lotto = autoLottoMachine.getAutoLotto();
			addLotto(lotto);
		}
	}

}
