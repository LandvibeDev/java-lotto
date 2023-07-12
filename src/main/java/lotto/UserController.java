package lotto;

import static lotto.config.LottoConfig.*;
import static lotto.validator.ErrorMessages.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import lotto.machines.AutoLottoMachine;
import lotto.machines.RewardMeasuringMachine;
import lotto.numberGame.Machine;

import lotto.validator.LottoValidator;

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
		userLottos = new ArrayList<>();
		rewardMeasuringMachine = new RewardMeasuringMachine(userLottos);
		numOfRanking = new int[6];

	}

	@Override
	public void run() throws IllegalArgumentException{
		try {
			purchaseLotto();
		} catch (IllegalArgumentException e) {
			validator.printErrorMessage(e);
			return;
		}

		try {
			rewardMeasuringMachine.run();
		} catch (IllegalArgumentException e) {
			validator.printErrorMessage(e);
			return;
		}
		totalReward = rewardMeasuringMachine.getTotalReward();
		printer.printResult((double)totalReward, (double)purchaseAmount);
	}

	public void purchaseLotto() throws IllegalArgumentException {
		printer.printInputPurchaseAmountMessage();
		String inStr = Console.readLine();

		try {
			validator.handleException(validator.isNotInteger(inStr), ONLY_INTEGER_MESSAGE.get());
		} catch (IllegalArgumentException e) {
			throw e;
		}

		purchaseAmount = Long.parseLong(inStr);
		try {
			validator.handleException(validator.isInvalidUnit(purchaseAmount), INVALID_UNIT_MESSAGE.get());
		} catch (IllegalArgumentException e) {
			throw e;
		}
		int numOfLotto = (int)(purchaseAmount / getUnitOfPurchase());
		printer.printNumberOfPurchaseMessage(numOfLotto);

		for (int i = 0; i < numOfLotto; i++) {
			autoLottoMachine.run();
			Lotto lotto = autoLottoMachine.getAutoLotto();

			addLotto(lotto);
		}
	}

	private static void addLotto(Lotto lotto) {
		userLottos.add(lotto);
	}

	public static int getNumOfRanking(int i) {
		return numOfRanking[i];
	}

	public static void increaseNumOfRanking(int i) {
		numOfRanking[i]++;
	}
}
