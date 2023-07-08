package lotto;

import static lotto.SettingValues.*;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != NUMBER_SIZE.get()) {
			throw new IllegalArgumentException("[ERROR] 숫자는 6개");
		}
		for (int n : numbers) {
			if (n < MIN_OF_RANGE.get() || n > MAX_OF_RANGE.get()) {
				throw new IllegalArgumentException("[ERROR] 1 ~ 45");
			}
		}
	}

	public List<Integer> getLottoNums() {
		return numbers;
	}

}
