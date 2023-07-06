package lotto;

import static lotto.Constant.ErrorMessage.*;
import static lotto.Constant.Rule.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
	public void validatePurchaseMoney(String input) {
		for (char digit : input.toCharArray()) {
			if (!Character.isDigit(digit)) {
				throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE.get());
			}
		}

		int purchaseMoney = Integer.parseInt(input);

		if (purchaseMoney < LOTTO_PRICE.get()) {
			throw new IllegalArgumentException(INVALID_PRICE_MESSAGE.get());
		}

		if (purchaseMoney % LOTTO_PRICE.get() != ZERO.get()) {
			throw new IllegalArgumentException(INVALID_PRICE_MESSAGE.get());
		}
	}

	public void validateWinningLotto(String input) {
		List<Integer> winningNumbers = new ArrayList<>();
		try {
			winningNumbers = Arrays.stream(input.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		} catch (Exception e) {
			throw new IllegalArgumentException(INVALID_FORMAT_MESSAGE.get());
		}

		if (winningNumbers.size() != NUMBER_SIZE.get()) {
			throw new IllegalArgumentException(INVALID_NUMBER_COUNT_MESSAGE.get());
		}

		for (int number : winningNumbers) {
			if (number < START_NUMBER.get() || number > END_NUMBER.get()) {
				throw new IllegalArgumentException(INVALID_RANGE_MESSAGE.get());
			}
		}
	}

	public void validateBonusNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE.get());
		}

		int bonusNumber = Integer.parseInt(input);
		if (bonusNumber < START_NUMBER.get() || bonusNumber > END_NUMBER.get()) {
			throw new IllegalArgumentException(INVALID_RANGE_MESSAGE.get());
		}
	}

}
