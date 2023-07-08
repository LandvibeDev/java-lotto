package lotto;

public enum Messages {

	RECEIPT_TITLE("당첨통계"),
	WINNING_MESSAGE_FORMAT_1("개 일치 ("),
	WINNING_MESSAGE_FORMAT_2(") - "),
	WINNING_MESSAGE_FORMAT_3("개"),
	REWARD_OF_FIRST_STR("2,000,000,000원"),
	REWARD_OF_SECOND_STR("30,000,000원"),
	REWARD_OF_THIRD_STR("1,500,000원"),
	REWARD_OF_FOURTH_STR("50,000원"),
	REWARD_OF_FIFTH_STR("5,000원"),
	PROFIT_RATIO_MESSAGE_FORMAT1("총 수익률은 %.1f"),
	PROFIT_RATIO_MESSAGE_FORMAT2("%입니다."),

	INPUT_WINNING_NUMS_MESSAGE("당첨 번호를 입력해 주세요."),
	INPUT_BONUS_NUM_MESSAGE("보너스 번호를 입력해 주세요."),

	PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
	NUMBER_OF_PURCHASE_MESSAGE("개를 구매했습니다.");



	private final String message;

	Messages(String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}