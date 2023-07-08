package lotto;

import static validate.ErrorMessages.*;

import java.util.List;

import validate.LottoValidator;

public class Lotto {
	private final List<Integer> numbers;
	private LottoValidator validator;

	public Lotto(List<Integer> numbers) {
		validator = new LottoValidator();
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validator.handleException(validator.isInvalidNumberSize(numbers.size()), INVALID_NUMBER_SIZE_MESSAGE.get());
		for (int n : numbers) {
			validator.handleException(validator.isOutOfRange(n), OUT_OF_RANGE_MESSAGE.get());
		}
	}

	public List<Integer> getLottoNums() {
		return numbers;
	}

}
