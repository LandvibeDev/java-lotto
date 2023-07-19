package lotto.validator;

public enum ErrorMessages {
	INVALID_NUMBER_SIZE_MESSAGE("[ERROR] 숫자는 6개"),
	OUT_OF_RANGE_MESSAGE("[ERROR] 1 ~ 45"),
	ONLY_INTEGER_MESSAGE("[ERROR] 숫자만 입력하세요"),
	INVALID_UNIT_MESSAGE("[ERROR] 1000원 단위로 입력해주세요"),
	NO_SPACE_MESSAGE("[ERROR] 공백없이 입력하세요"),
	ALREADY_DRAWN_MESSAGE("[ERROR] 이미 추첨된 번호입니다.");
	private final String errorMessage;

	ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String get() {
		return errorMessage;
	}
}
