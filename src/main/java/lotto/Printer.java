package lotto;

import static lotto.numberGame.NumConverter.*;
import static lotto.config.Messages.*;
import static lotto.config.LottoConfig.*;
import static lotto.config.SettingValues.*;

import static lotto.UserController.*;

import java.util.Arrays;
import java.util.List;

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

	public void printList(List<?> list) {
		String listToStr;
		listToStr = Arrays.toString(list.toArray());
		System.out.println(listToStr);
	}

	public void printResult(double totalReward, double purchaseAmount) {
		printReceiptTitle();
		for (int ranking : getRankings()) {
			printRankingResult(ranking);
		}
		printProfitRatio(totalReward, purchaseAmount);
	}

	public void printRankingResult(int i) {
		if (i == SECOND.get()) {
			System.out.printf(WINNING_MESSAGE_FORMAT_SECOND.get(),
				getPoint(i), intToString(getReward(i))+WON.get(),getNumOfRanking(i));
			return;
		}
		System.out.printf(WINNING_MESSAGE_FORMAT_NORMAL.get(),
			getPoint(i),intToString(getReward(i))+WON.get(),getNumOfRanking(i));
	}

	public void printReceiptTitle() {
		System.out.println(RECEIPT_TITLE.get());
	}

	public void printProfitRatio(double totalReward, double purchaseAmount) {
		double profitRatio;
		String profitRatioStr;
		profitRatio = (totalReward / purchaseAmount) * getPERCENTAGE();
		profitRatioStr = doubleToString(profitRatio,getCutSize());
		System.out.printf(PROFIT_RATIO_MESSAGE_FORMAT.get(), profitRatioStr);
	}


}
