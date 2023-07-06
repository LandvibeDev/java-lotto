package lotto;

public class Constant {
	public enum Rule {
		START_NUMBER(1),
		END_NUMBER(45),
		NUMBER_SIZE(6),
		LOTTO_PRICE(1000),
		WINNING_RANGE(5),
		AMOUNT_OF_MONEY_1st(2000000000),
		AMOUNT_OF_MONEY_2nd(30000000),
		AMOUNT_OF_MONEY_3rd(1500000),
		AMOUNT_OF_MONEY_4th(50000),
		AMOUNT_OF_MONEY_5th(5000),
		MATCH_COUNT_1st(6),
		MATCH_COUNT_2nd(5),
		MATCH_COUNT_3rd(5),
		MATCH_COUNT_4th(4),
		MATCH_COUNT_5th(3),
		ZERO(0),
		ONE(1),
		HUNDRED(100);

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

	public enum ResponseMessage {
		LOTTO_COUNT_MESSAGE("\n%d개를 구매했습니다."),
		WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
		MATCH_MESSAGE("%d개 일치 (%s원) - %d개"),
		MATCH_MESSAGE_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
		RATE_OF_RETURN_MESSAGE("총 수익률은 %.1f%%입니다.");
		private final String responseMessage;

		ResponseMessage(String responseMessage) {
			this.responseMessage = responseMessage;
		}

		@Override
		public String toString() {
			return responseMessage;
		}

		public String getMessage(int lottoCount) {
			return String.format(responseMessage, lottoCount);
		}

		public String getMessage(double rateOfReturn) {
			return String.format(responseMessage, rateOfReturn);
		}

		public String getMatchMessage(int lottoCount, String price, int matchCount) {
			return String.format(responseMessage, lottoCount, price, matchCount);
		}

	}

	public enum ErrorMessage {
		ONLY_NUMBER_MESSAGE("숫자만 입력해 주세요."),
		INVALID_PRICE_MESSAGE("로또 가격 단위로 로또를 구매할 수 없습니다."),
		INVALID_FORMAT_MESSAGE("올바른 형식으로 입력해 주세요."),
		INVALID_NUMBER_COUNT_MESSAGE("올바른 개수의 번호를 입력해 주세요"),
		INVALID_RANGE_MESSAGE("올바른 범위의 번호를 입력해 주세요");

		private final String errorMessage;

		ErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String get() {
			return "[ERROR] " + errorMessage;
		}
	}

	public enum Format {

		DELIMITER(", "),
		PREFIX("["),
		SUFFIX("]"),
		REGEX(","),
		DECIMAL_PATTERN("#,###");
		private final String format;

		Format(String format) {
			this.format = format;
		}

		public String get() {
			return format;
		}
	}

}
