package lotto;

public enum Message {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INPUT_SIXDIGIT_NUMVER("6자리 숫자를 입력해 주세요."),
    NOT_INTAGER_ERROR_MESSAGE("[ERROR] : 정수값이 아닙니다."),
    NOT_THOUSAND_ERROR_MESSAGE("[ERROR] : 천원 단위로 입력해주세요."),
    NOT_OUTRANGE_NUMBER_ERROR_MESSAGE("[ERROR] : 로또 번호의 범위를 초과하였습니다."),
    OVERLAP_NUMBER_ERROR_MESSAGE("[ERROR] : 중복되는 번호입니다.");




    private final String message;

    Message(String message){
        this.message = message;
    }

    public  String getMessage(){
        return message;
    }
}
