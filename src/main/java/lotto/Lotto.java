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
}
