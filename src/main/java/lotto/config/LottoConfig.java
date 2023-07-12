package lotto.config;

public class LottoConfig {

	private static final int[] rewards = {
		SettingValues.FAIL.get(), SettingValues.REWARD_OF_FIRST.get(), SettingValues.REWARD_OF_SECOND.get(),
		SettingValues.REWARD_OF_THIRD.get(), SettingValues.REWARD_OF_FOURTH.get(), SettingValues.REWARD_OF_FIFTH.get()};

	private static final int[] rankings = {SettingValues.FIRST.get(), SettingValues.SECOND.get(),
		SettingValues.THIRD.get(), SettingValues.FOURTH.get(), SettingValues.FIFTH.get()};

	private static final int[] points = {
		SettingValues.ZERO.get(), SettingValues.POINT_OF_FIRST.get(), SettingValues.POINT_OF_SECOND.get(),
		SettingValues.POINT_OF_THIRD.get(),
		SettingValues.POINT_OF_FOURTH.get(), SettingValues.POINT_OF_FIFTH.get()};
	private static final int CUT_SIZE = 1;
	private static final double PERCENTAGE = 100.0;
	private static final long UNIT_OF_PURCHASE = 1000L;
	private static final String DELIM = ",";

	public static int getReward(int i) {
		return rewards[i];
	}

	public static double getPERCENTAGE() {
		return PERCENTAGE;
	}

	public static long getUnitOfPurchase() {
		return UNIT_OF_PURCHASE;
	}

	public static String getDELIM() {
		return DELIM;
	}

	public static int[] getRankings() {
		return rankings;
	}

	public static int getPoint(int i) {
		return points[i];
	}

	public static int getCutSize() {
		return CUT_SIZE;
	}

}
