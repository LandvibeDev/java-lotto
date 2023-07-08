package machines;

import static config.SettingValues.*;
import static config.LottoConfig.*;

import lotto.Lotto;
import machines.interfaces.JudgeMachine;

public class RewardMeasuringMachine implements JudgeMachine {

	LottoCompareMachine compareMachine;
	long totalReward;

	public RewardMeasuringMachine() {
		compareMachine = new LottoCompareMachine();
		totalReward = 0;
	}

	@Override
	public void run() {
		compareMachine.run();
		int winPoint;
		int ranking;
		for (Lotto lotto : getUserLottos()) {
			winPoint = compareMachine.compare(lotto.getLottoNums());
			ranking = rank(winPoint);
			totalReward += getReward(ranking);
		}
	}

	@Override
	public int rank(int winPoint) {
		int ranking = CALCULATOR.get() - winPoint;
		if (ranking <= MIN_WINNING_RANKING.get()) {
			increaseNumOfRanking(ranking);
			return ranking;
		}
		return 0;
	}

	public long getTotalReward() {
		return totalReward;
	}

}
