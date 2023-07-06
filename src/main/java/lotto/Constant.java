package lotto;

public class Constant {
	public enum Rule {
		START_NUMBER(1),
		END_NUMBER(45),
		NUMBER_SIZE(6),
		LOTTO_PRICE(1000),
		;

		private final int number;

		Rule(int number) {
			this.number = number;
		}

		public int get() {
			return number;
		}
	}

	public enum RequestMessage {
		REQUEST_INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
		REQUEST_INPUT_WINNING_LOTTO("\n당첨 번호를 입력해 주세요."),
		REQUEST_INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");
		private final String requestMessage;

		RequestMessage(String message) {
			this.requestMessage = message;
		}

		@Override
		public String toString() {
			return requestMessage;
		}
	}

}
