package validator;

public enum ErrorMessage {
    INPUT_SIXDIGIT_NUMBER("[ERROR] : 6자리 숫자를 입력해 주세요."),
    NOT_INTAGER_ERROR_MESSAGE("[ERROR] : 정수값이 아닙니다."),
    NOT_THOUSAND_ERROR_MESSAGE("[ERROR] : 천원 단위로 입력해주세요."),
    NOT_OUTRANGE_NUMBER_ERROR_MESSAGE("[ERROR] : 로또 번호의 범위를 초과하였습니다."),
    OVERLAP_NUMBER_ERROR_MESSAGE("[ERROR] : 중복되는 번호입니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return errorMessage;
    }
}
