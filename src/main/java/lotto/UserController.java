package lotto;

import static config.LottoConfig.*;
import static validate.ErrorMessages.*;

import java.util.ArrayList;
import java.util.List;

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
	private static int[] numOfRanking;
	private static List<Lotto> userLottos;

	UserController() {
		validator = new LottoValidator();
		printer = new Printer();
		autoLottoMachine = new AutoLottoMachine();
		rewardMeasuringMachine = new RewardMeasuringMachine();
		numOfRanking = new int[6];
		userLottos = new ArrayList<>();
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

	public static List<Lotto> getUserLottos() {
		return userLottos;
	}

	public static void addLotto(Lotto lotto) {
		userLottos.add(lotto);
	}

	public static int getNumOfRanking(int i) {
		return numOfRanking[i];
	}

	public static void increaseNumOfRanking(int i) {
		numOfRanking[i]++;
	}
}
