package lotto;

public enum ErrorMessage {
    WRONG_CHARACTER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATION("[ERROR] 중복된 숫자가 있습니다"),
    WRONG_MONEY("[ERROR] 로또는 천원 단위로 구매할 수 있습니다");

    public String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
