package lotto;

public enum Message {


    INPUT_PRICE("구입 금액을 입력해 주세요."),
    OUTPUT_AMOUNT("개를 구매했습니다."),
    INPUT_NUMBER("당첨 번호를 입력해 주세요"),
    INPUT_BONUS("보너스 번호를 입력해 주세요"),
    WINNING_RESULT("당첨 통계\n___"),
    EQUAL_THREE("3개 일치 (5,000원) - "),
    EQUAL_FOUR("4개 일치 (50,000원) - "),
    EQUAL_FIVE("5개 일치 (1,500,000원) - "),
    EQUAL_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    EQUAL_SIX("6개 일치 (2,000,000,000원) - "),
    PROFIT_RESULT("총 수익률은 ");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getEqualValue(int x) {
        return value + x + "개";
    }

    public String getProfitValue(int result, int price) {
        return value + 100 * ((double) result / price) + "%입니다.";
    }
}
