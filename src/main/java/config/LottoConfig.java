package config;

import static config.Messages.*;
import static config.SettingValues.*;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;

public class LottoConfig {
	private static final int[] numOfRanking = new int[6];
	private static final String NOTHING = "";
	private static final int[] rewards = {FAIL.get(), REWARD_OF_FIRST.get(), REWARD_OF_SECOND.get(),
		REWARD_OF_THIRD.get(), REWARD_OF_FOURTH.get(), REWARD_OF_FIFTH.get()};

	private static final String[] rewardsStr = {NOTHING, REWARD_OF_FIRST_STR.get(), REWARD_OF_SECOND_STR.get(),
		REWARD_OF_THIRD_STR.get(), REWARD_OF_FOURTH_STR.get(), REWARD_OF_FIFTH_STR.get()};
	private static final int[] rankings = {FIRST.get(), SECOND.get(), THIRD.get(), FOURTH.get(), FIFTH.get()};

	private static final int[] points = {ZERO.get(), POINT_OF_FIRST.get(), POINT_OF_SECOND.get(), POINT_OF_THIRD.get(),
		POINT_OF_FOURTH.get(), POINT_OF_FIFTH.get()};
	private static final String[] formats = {NOTHING, WINNING_MESSAGE_FORMAT_FIRST.get(),
		WINNING_MESSAGE_FORMAT_SECOND.get(), WINNING_MESSAGE_FORMAT_THIRD.get(), WINNING_MESSAGE_FORMAT_FOURTH.get(),
		WINNING_MESSAGE_FORMAT_FIFTH.get()};
	private static final double PERCENTAGE = 100.0;
	private static final long UNIT_OF_PURCHASE = 1000L;
	private static final List<Lotto> userLottos = new ArrayList<>();
	private static final String DELIM = ",";

	public static int getNumOfRanking(int i) {
		return numOfRanking[i];
	}
	public static void increaseNumOfRanking(int i) {
		numOfRanking[i]++;
	}

	public static int getReward(int i) {
		return rewards[i];
	}

	public static double getPERCENTAGE() {
		return PERCENTAGE;
	}

	public static long getUnitOfPurchase() {
		return UNIT_OF_PURCHASE;
	}

	public static List<Lotto> getUserLottos() {
		return userLottos;
	}

	public static void addLotto(Lotto lotto) {
		userLottos.add(lotto);
	}

	public static String getDELIM() {
		return DELIM;
	}

	public static String getRewardStr(int i) {
		return rewardsStr[i];
	}

	public static int[] getRankings() {
		return rankings;
	}

	public static int getPoint(int i) {
		return points[i];
	}

	public static String getFormat(int i) {
		return formats[i];
	}
}
