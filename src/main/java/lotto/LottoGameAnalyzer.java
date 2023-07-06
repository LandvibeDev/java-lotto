package lotto;

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
}
