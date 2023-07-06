package lotto;

import static lotto.Constant.*;
import static lotto.Constant.Rule.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import lotto.Constant.ResponseMessage;

public class LottoGameAnalyzer {

	public void analyze(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList, int purchaseMoney) {
		Score score = calculateScore(winningLotto, bonusNumber, lottoList);
		double rateOfReturn = calculateReteOfReturn(purchaseMoney, score);
		printWinningStatistics(score);
		printRateOfReturn(rateOfReturn);
	}

	private Score calculateScore(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList) {
		Score score = new Score();

		for (Lotto lotto : lottoList) {
			int matchCount = lotto.countMatchingNumbers(winningLotto);
			boolean isBonusNumberMath = lotto.getNumbers().contains(bonusNumber);
			score.increaseScore(matchCount, isBonusNumberMath);
		}

		return score;
	}

	private double calculateReteOfReturn(int purchaseMoney, Score score) {
		List<Integer> priceList = Arrays.asList(AMOUNT_OF_MONEY_1st.get(), AMOUNT_OF_MONEY_2nd.get(),
			AMOUNT_OF_MONEY_3rd.get(), AMOUNT_OF_MONEY_4th.get(), AMOUNT_OF_MONEY_5th.get());
		List<Integer> scoreList = score.getScoresAsList();
		long totalWonMoney = ZERO.get();

		for (int iterator = ZERO.get(); iterator < WINNING_RANGE.get(); iterator++) {
			totalWonMoney += scoreList.get(iterator) * priceList.get(iterator);
		}

		double rateOfReturn = ((double)totalWonMoney / (double)purchaseMoney) * HUNDRED.get();

		return rateOfReturn;
	}

	public void printWinningStatistics(Score score) {
		System.out.println(ResponseMessage.WINNING_STATISTICS_MESSAGE);

		System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_5th.get(),
			formatNumber(AMOUNT_OF_MONEY_5th.get()), score.getWinFifthPlace()));

		System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_4th.get(),
			formatNumber(AMOUNT_OF_MONEY_4th.get()), score.getWinFourthPlace()));

		System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_3rd.get(),
			formatNumber(AMOUNT_OF_MONEY_3rd.get()), score.getWinThirdPlace()));

		System.out.println(ResponseMessage.MATCH_MESSAGE_WITH_BONUS.getMatchMessage(MATCH_COUNT_2nd.get(),
			formatNumber(AMOUNT_OF_MONEY_2nd.get()), score.getWinSecondPlace()));

		System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_1st.get(),
			formatNumber(AMOUNT_OF_MONEY_1st.get()), score.getWinFirstPlace()));
	}

	public String formatNumber(int amountOfMoney) {
		DecimalFormat decimalFormat = new DecimalFormat(Format.DECIMAL_PATTERN.get());
		String formattedNumber = decimalFormat.format(amountOfMoney);
		return formattedNumber;
	}

	public void printRateOfReturn(double rateOfReturn) {
		System.out.println(ResponseMessage.RATE_OF_RETURN_MESSAGE.getMessage(rateOfReturn));
	}
}
