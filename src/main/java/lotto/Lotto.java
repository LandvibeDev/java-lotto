package lotto;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입니다.");
		}
		for (int n : numbers) {
			if (n < 1 || n > 45) {
				throw new IllegalArgumentException("[ERROR] 당첨 번호의 범위는 1~45 입니다. ");
			}
		}
	}
	public List<Integer> getLottoNums(){
		return numbers;
	}

}
