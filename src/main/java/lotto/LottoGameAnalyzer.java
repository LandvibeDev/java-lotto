package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoGameAnalyzer {

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
		List<Integer> priceList = Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000);
		List<Integer> scoreList = score.getScoresAsList();
		long totalWonMoney = 0;

		for (int iterator = 0; iterator < 5; iterator++) {
			totalWonMoney += scoreList.get(iterator) * priceList.get(iterator);
		}

		double rateOfReturn = ((double)totalWonMoney / (double)purchaseMoney) * 100;

		return rateOfReturn;
	}
}
