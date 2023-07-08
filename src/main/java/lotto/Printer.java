package lotto;

import static config.Messages.*;
import static config.LottoConfig.*;

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
		for (int ranking : getRankings()) {
			printRankingResult(ranking);
		}
		printProfitRatio(totalReward, purchaseAmount);
	}

	public void printRankingResult(int i) {
		System.out.printf(getFormat(i), getPoint(i), getRewardStr(i), getNumOfRanking(i));
		System.out.println();
	}

	public void printReceiptTitle() {
		System.out.println(RECEIPT_TITLE.get());
	}

	public void printProfitRatio(double totalReward, double purchaseAmount) {
		double profitRatio;
		profitRatio = (totalReward / purchaseAmount) * getPERCENTAGE();
		System.out.printf(PROFIT_RATIO_MESSAGE_FORMAT1.get(), profitRatio);
		System.out.print(PROFIT_RATIO_MESSAGE_FORMAT2.get());
		System.out.println();
	}
}
