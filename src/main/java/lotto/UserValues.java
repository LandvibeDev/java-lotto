package lotto;

import java.util.ArrayList;
import java.util.List;

public class UserValues {
	private static final int[] numOfRanking = new int[6];
	private static final List<Lotto> userLottos = new ArrayList<>();

	public static int getNumOfRanking(int i) {
		return numOfRanking[i];
	}

	public static void increaseNumOfRanking(int i) {
		numOfRanking[i]++;
	}

	public static List<Lotto> getUserLottos() {
		return userLottos;
	}

	public static void addLotto(Lotto lotto) {
		userLottos.add(lotto);
	}
}
