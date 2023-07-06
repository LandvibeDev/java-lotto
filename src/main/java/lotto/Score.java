package lotto;

public class Score {
	int winFirstPlace;
	int winSecondPlace;
	int winThirdPlace;
	int winFourthPlace;
	int winFifthPlace;

	public Score() {
		this.winFirstPlace = 0;
		this.winSecondPlace = 0;
		this.winThirdPlace = 0;
		this.winFourthPlace = 0;
		this.winFifthPlace = 0;
	}

	public void increaseScore(int matchCount, boolean isBonusNumberMatch) {
		if (matchCount == 6) {
			winFirstPlace++;
		}
		if (matchCount == 5 && isBonusNumberMatch) {
			winSecondPlace++;
		}
		if (matchCount == 5) {
			winThirdPlace++;
		}
		if (matchCount == 4) {
			winFourthPlace++;
		}
		if (matchCount == 3) {
			winFifthPlace++;
		}
	}

}
