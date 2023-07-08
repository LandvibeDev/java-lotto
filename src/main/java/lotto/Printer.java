package lotto;

import static lotto.Messages.*;
import static lotto.SettingValues.*;
import static lotto.SharingVariables.*;

public class Printer {
	public void printInputPurchaseAmountMessage() {
		System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE.get());
	}

	public void printNumberOfPurchaseMessage(int number) {
		System.out.println(number + NUMBER_OF_PURCHASE_MESSAGE.get());
	}

	public void printInputWinningNumMessage() {
		System.out.println(INPUT_WINNING_NUMS_MESSAGE.get());
	}

	public void printInputBonusNumMessage() {
		System.out.println(INPUT_BONUS_NUM_MESSAGE.get());
	}

	public void printResult(double totalReward, double purchaseAmount) {
		printReceiptTitle();
		for (int i = FIRST.get(); i <= FIFTH.get(); i++) {
			printRankingResult(i);
		}
		printProfitRatio(totalReward, purchaseAmount);
	}

	public void printRankingResult(int i) {
		System.out.printf(formats[i], points[i], rewadsStr[i], numOfRanking[i]);
		System.out.println();
	}

	public void printReceiptTitle() {
		System.out.println(RECEIPT_TITLE.get());
	}

	public void printProfitRatio(double totalReward, double purchaseAmount) {
		double profitRatio;
		profitRatio = (totalReward / purchaseAmount) * PERCENTAGE;
		System.out.printf(PROFIT_RATIO_MESSAGE_FORMAT1.get(), profitRatio);
		System.out.print(PROFIT_RATIO_MESSAGE_FORMAT2.get());
		System.out.println();
	}
}
