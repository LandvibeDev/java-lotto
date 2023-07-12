package lotto.machines;

import static lotto.config.SettingValues.*;
import static lotto.config.LottoConfig.*;
import static lotto.UserController.*;

import java.util.List;

import lotto.Lotto;
import lotto.numberGame.JudgeMachine;

public class RewardMeasuringMachine implements JudgeMachine {

	LottoCompareMachine compareMachine;
	List<Lotto> userLottos;
	long totalReward;

	public RewardMeasuringMachine(List<Lotto> userLottos) {
		compareMachine = new LottoCompareMachine();
		totalReward = 0;
		this.userLottos = userLottos;
	}

	@Override
	public void run() {
		try {
			compareMachine.run();
		} catch (IllegalArgumentException e) {
			throw e;
		}

		int winPoint;
		int ranking;
		for (Lotto lotto : userLottos) {
			winPoint = compareMachine.compare(lotto.getLottoNums());
			ranking = rank(winPoint);
			totalReward += getReward(ranking);
		}
	}

	@Override
	public int rank(Integer winPoint) {
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
