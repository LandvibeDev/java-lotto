package lotto;

import static lotto.Constant.Rule.*;

import java.util.Arrays;
import java.util.List;

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
		System.out.println("\n당첨 통계\n---");
		System.out.println("3개 일치 (5,000원) - " + score.getWinFifthPlace() + "개");
		System.out.println("4개 일치 (50,000원) - " + score.getWinFourthPlace() + "개");
		System.out.println("5개 일치 (1,500,000원) - " + score.getWinThirdPlace() + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + score.getWinSecondPlace() + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + score.getWinFirstPlace() + "개");
	}

	public void printRateOfReturn(double rateOfReturn) {
		System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
	}
}
