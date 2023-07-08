package lotto;

import static lotto.SharingVariables.*;

import java.util.List;

public class RewardMeasuringMachine implements Machine{

	LottoCompareMachine compareMachine;
	List<Lotto> userLottos;
	UserController controller;
	long totalReward;
	RewardMeasuringMachine(){
		compareMachine = new LottoCompareMachine();
		controller = new UserController();
		totalReward = 0;
	}
	@Override
	public void run(){
		userLottos = controller.getUserLottos();
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
		if (ranking <= 5) {
			rankings[ranking]++;
			return ranking;
		}
		return 0;
	}


}
