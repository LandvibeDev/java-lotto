package lotto;

import static lotto.Constant.Rule.*;

import java.util.Arrays;
import java.util.List;

public class Score {
	int winFirstPlace;
	int winSecondPlace;
	int winThirdPlace;
	int winFourthPlace;
	int winFifthPlace;

	public Score() {
		this.winFirstPlace = ZERO.get();
		this.winSecondPlace = ZERO.get();
		this.winThirdPlace = ZERO.get();
		this.winFourthPlace = ZERO.get();
		this.winFifthPlace = ZERO.get();
	}

	public void increaseScore(int matchCount, boolean isBonusNumberMatch) {
		if (matchCount == MATCH_COUNT_1st.get()) {
			winFirstPlace++;
		}
		if (matchCount == MATCH_COUNT_2nd.get() && isBonusNumberMatch) {
			winSecondPlace++;
		}
		if (matchCount == MATCH_COUNT_3rd.get()) {
			winThirdPlace++;
		}
		if (matchCount == MATCH_COUNT_4th.get()) {
			winFourthPlace++;
		}
		if (matchCount == MATCH_COUNT_5th.get()) {
			winFifthPlace++;
		}
	}

	public List<Integer> getScoresAsList() {
		return Arrays.asList(winFirstPlace, winSecondPlace, winThirdPlace, winFourthPlace, winFifthPlace);
	}

	public int getWinFirstPlace() {
		return winFirstPlace;
	}

	public int getWinSecondPlace() {
		return winSecondPlace;
	}

	public int getWinThirdPlace() {
		return winThirdPlace;
	}

	public int getWinFourthPlace() {
		return winFourthPlace;
	}

	public int getWinFifthPlace() {
		return winFifthPlace;
	}
}
