package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(Rule lottoGameRule) {
		int startNumber = lottoGameRule.getStartNumber();
		int endNumber = lottoGameRule.getEndNumber();
		int numberSize = lottoGameRule.getNumberSize();
		numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, numberSize);
	}

	public Lotto(List<Integer> winningNumbers) {
		this.numbers = winningNumbers;
	}

	public Lotto() {
		numbers = new ArrayList<>();
	}

	@Override
	public String toString() {
		return numbers.stream()
			.sorted()
			.map(Object::toString)
			.collect(Collectors.joining(", ", "[", "]"));
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int countMatchingNumbers(Lotto winningLotto) {
		List<Integer> winningNumbers = winningLotto.getNumbers();

		return (int)numbers.stream()
			.filter(winningNumbers::contains)
			.count();
	}

}
