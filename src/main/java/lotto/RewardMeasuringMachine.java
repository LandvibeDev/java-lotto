package lotto;

import static lotto.SettingValues.*;
import static lotto.SharingVariables.*;

import java.util.List;

public class RewardMeasuringMachine implements Machine {

	LottoCompareMachine compareMachine;
	long totalReward;

	RewardMeasuringMachine() {
		compareMachine = new LottoCompareMachine();
		totalReward = 0;
	}

	@Override
	public void run() {
		compareMachine.run();
		int winPoint;
		int ranking;
		for (Lotto lotto : userLottos) {
			winPoint = compareMachine.compare(lotto);
			ranking = rank(winPoint);
			totalReward += rewards[ranking];
		}
	}

	public int rank(int winPoint) {
		int ranking = 8 - winPoint;
		if (ranking <= MIN_WINNING_RANKING.get()) {
			numOfRanking[ranking]++;
			return ranking;
		}
		return 0;
	}
	public long getTotalReward(){
		return totalReward;
	}

}
