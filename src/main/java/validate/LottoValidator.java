package validate;

import static config.SettingValues.*;

import java.util.List;

public class LottoValidator implements Validator {

	@Override
	public void handleException(boolean condition, String ErrorMessage) {
		if (condition) {
			throw new IllegalArgumentException(ErrorMessage);
		}
	}

	public boolean isThereSpace(String inStr) {
		return inStr.contains(" ");
	}

	public boolean isNotInteger(String inStr) {
		for (char c : inStr.toCharArray()) {
			if (c < '0' || c > '9')
				return true;
		}
		return false;
	}

	public boolean isInvalidNumberSize(int numSize) {
		return (numSize != NUMBER_SIZE.get());
	}

	public boolean isOutOfRange(int number) {
		return (number < MIN_OF_RANGE.get() || number > MAX_OF_RANGE.get());
	}

	public boolean isInvalidUnit(long purchaseAmount) {
		return (purchaseAmount % (long)PRICE_OF_LOTTO.get() != 0);
	}

	public boolean isDuplicatedNum(List<Integer> Numbers, Integer num) {
		return Numbers.contains(num);
	}

}
