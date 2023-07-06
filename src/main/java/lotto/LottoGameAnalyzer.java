package lotto;

import static lotto.Constant.*;
import static lotto.Constant.Rule.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import lotto.Constant.ResponseMessage;

public class LottoGameAnalyzer {

	private View view;

	public LottoGameAnalyzer() {
		view = new View();
	}

	public void analyze(Lotto winningLotto, int bonusNumber, List<Lotto> lottoList, int purchaseMoney) {
		Score score = calculateScore(winningLotto, bonusNumber, lottoList);
		double rateOfReturn = calculateReteOfReturn(purchaseMoney, score);
		view.printWinningStatistics(score);
		view.printRateOfReturn(rateOfReturn);
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
		List<Integer> prizeList = Arrays.asList(AMOUNT_OF_MONEY_1st.get(), AMOUNT_OF_MONEY_2nd.get(),
			AMOUNT_OF_MONEY_3rd.get(), AMOUNT_OF_MONEY_4th.get(), AMOUNT_OF_MONEY_5th.get());
		List<Integer> scoreList = score.getScoresAsList();
		long totalWonMoney = ZERO.get();

		for (int iterator = ZERO.get(); iterator < WINNING_RANGE.get(); iterator++) {
			totalWonMoney += scoreList.get(iterator) * prizeList.get(iterator);
		}

		double rateOfReturn = ((double)totalWonMoney / (double)purchaseMoney) * HUNDRED.get();

		return rateOfReturn;
	}
}
