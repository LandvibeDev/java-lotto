package lotto;

public enum SettingValues {
	MIN_OF_RANGE(1),
	MAX_OF_RANGE(45),
	NUMBER_SIZE(6),
	PRICE_OF_LOTTO(1000),
	WINNING_RANGE(5),
	REWARD_OF_FIRST(2000000000),
	REWARD_OF_SECOND(30000000),
	REWARD_OF_THIRD(1500000),
	REWARD_OF_FOURTH(50000),
	REWARD_OF_FIFTH(5000),
	FAIL(0),
	ZERO(0);

	private final int value;

	SettingValues(int value) {
		this.value = value;
	}

	public int get() {
		return value;
	}
}
