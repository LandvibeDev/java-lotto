package lotto;

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
}
