package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
	public void validatePurchaseMoney(String input) {
		for (char digit : input.toCharArray()) {
			if (!Character.isDigit(digit)) {
				throw new IllegalArgumentException("[ERROR]" + " 숫자만 입력해 주세요.");
			}
		}

		int purchaseMoney = Integer.parseInt(input);

		if (purchaseMoney < 1000) {
			throw new IllegalArgumentException("[ERROR] " + purchaseMoney + "원으로 로또를 구매할 수 없습니다.");
		}

		if (purchaseMoney % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 로또 가격 단위로 로또를 구매할 수 없습니다.");
		}
	}

	public void validateWinningLotto(String input) {
		List<Integer> winningNumbers = new ArrayList<>();
		try {
			winningNumbers = Arrays.stream(input.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		} catch (Exception e) {
			throw new IllegalArgumentException("[ERROR] 올바른 형식으로 입력해 주세요.");
		}

		if (winningNumbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 올바른 개수의 번호를 입력해 주세요");
		}

		for (int number : winningNumbers) {
			if (number < 1 || number > 45) {
				throw new IllegalArgumentException("[ERROR] 올바른 범위의 번호를 입력해 주세요");
			}
		}
	}

}
