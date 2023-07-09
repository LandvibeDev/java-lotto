package lotto;

public class Message {
    public enum Input {
        PURCHASE_MONEY("구입금액을 입력해 주세요."),
        WINNER_NUMBER("\n당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

        private final String inputMessage;

        Input(String message) {
            inputMessage = message;
        }

        @Override
        public String toString() {
            return inputMessage;
        }
    }

    public enum Output {
        PURCHASE_QUANTITY("\n%d개를 구매했습니다."),
        RESULT_STAT("\n당첨 통계\n---"),
        RESULT_RATE("총 수익률은 %.1f%%입니다."),
        RESULT_CONTENTS("""
                3개 일치 (%s원) - %d개
                4개 일치 (%s원) - %d개
                5개 일치 (%s원) - %d개
                5개 일치, 보너스 볼 일치 (%s원) - %d개
                6개 일치 (%s원) - %d개""");

        private final String outputMessage;
        Output(String message) {
            outputMessage = message;
        }

        public String toQuantityFormat(int lottoQuantity) {
            return String.format(outputMessage, lottoQuantity);
        }

        public String toRateFormat(double rate) {
            return String.format(outputMessage, rate);
        }

        public String toContentsFormat(ResultLottoData resultData) {
            return String.format(outputMessage,
                    Number.Prize.THREE_MATCH.toDecimalFormat(), resultData.threeMatchCount,
                    Number.Prize.FOUR_MATCH.toDecimalFormat(), resultData.fourMatchCount,
                    Number.Prize.FIVE_MATCH.toDecimalFormat(), resultData.fiveMatchCount,
                    Number.Prize.FIVE_BONUS_MATCH.toDecimalFormat(), resultData.fiveAndBonusMatchCount,
                    Number.Prize.SIX_MATCH.toDecimalFormat(), resultData.sixMatchCount);
        }

        @Override
        public String toString() {
            return outputMessage;
        }
    }

    public enum Error {
        PURCHASE_AMOUNT("구입 금액은 로또 한장 가격의 단위로 입력해주세요."),
        LOTTO_NUMBER("로또 번호는 중복되지 않는 1부터 45 사이의 숫자여야 합니다."),
        BONUS_NUMBER("중복되지 않는 한 개의 보너스 번호를 입력해주세요.");

        private final String errorMessage;

        Error(String input) {
            this.errorMessage = input;
        }

        public String toErrorFormat() {
            return "[ERROR] " + errorMessage;
        }
    }
}
