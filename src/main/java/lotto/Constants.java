package lotto;

public class Constants {
    public static final class NumberRange {
        public static final int START = 1;
        public static final int END = 45;
        public static final int COUNT = 6;
    }

    public static final class Lotto {
        public static final int PRICE = 1000;
        public static final String DELIM = ",";
        public static final int DECIMAL_PLACE = 1;

    }

    public static final class Winning {
        public static final int FIRST = 6;
        public static final int SECOND = 0;
        public static final int THIRD = 5;
        public static final int FOURTH = 4;
        public static final int FIFTH = 3;
    }

    public static final class Reward {
        public static final int FIRST_PRICE = 2000000000;
        public static final int SECOND_PRICE = 30000000;
        public static final int THIRD_PRICE = 1500000;
        public static final int FOURTH_PRICE = 50000;
        public static final int FIFTH_PRICE = 5000;
    }

    public final static class Message {
        public static final String PURCHASE = "구입금액을 입력해 주세요.";
        public static final String PURCHASE_COMPLETE = "개를 구매했습니다.";
        public static final String ANSWER_LOTTO = "\n당첨 번호를 입력해 주세요.";
        public static final String BONUS = "\n보너스 번호를 입력해 주세요.";
    }

    public final static class Exception {
        public static final String ERROR_MESSAGE = "[ERROR] ";
        public static final String VALID_INTEGER = "정수를 입력하세요.";
        public static final String VALID_MULTIPLES = "원 단위로 구입 금액을 입력하세요.";
        public static final String NO_DUPLICATE = "중복되지 않는 정수를 입력하세요.";
        public static final String VALID_RANGE = " 사이의 정수를 입력하세요.";
        public static final String BETWEEN_SIGN = " ~ ";
    }

}
