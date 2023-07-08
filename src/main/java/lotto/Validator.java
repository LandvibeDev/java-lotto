package lotto;

import static lotto.SettingValues.*;

public class Validator {
	char ZERO = '0';
	char NINE = '9';

	public boolean isThereSpace(String inStr) {
		return inStr.contains(" ");
	}

	public boolean isNotInteger(String inStr) {
		for (char c : inStr.toCharArray()) {
			if (c < ZERO || c > NINE)
				return true;
		}
		return false;
	}

	public boolean isInvalidUnit(int purchaseAmount) {
		return (purchaseAmount % PRICE_OF_LOTTO.get() != 0);
	}
}
