package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.ErrorMessage.*;

public class Validation {

    public void validateMoney(String money) {
        moneyCharacterCheck(money);
        checkAmountOfMoney(money);
    }

    public void validateWinningNumbers(String mainNumbers, String bonusNumber) {
        mainNumberCharacterCheck(mainNumbers);
        bonusNumberCharacterCheck(bonusNumber);
        winningNumberDuplicationCheck(mainNumbers, bonusNumber);
    }

    private void mainNumberCharacterCheck(String mainNumbers) {
        String[] mainNumberList = mainNumbers.split(",");
        for (String mainNumber : mainNumberList) {
            for (Character character : mainNumber.toCharArray()) {
                if (!Character.isDigit(character)) {
                    throw new IllegalArgumentException(WRONG_CHARACTER.message);
                }
            }
        }
    }

    private void bonusNumberCharacterCheck(String bonusNumber) {
        for (Character character : bonusNumber.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException(WRONG_CHARACTER.message);
            }
        }
    }

    private void winningNumberDuplicationCheck(String inputMainNumbers, String inputBonusNumber) {
        Set<Integer> set = new HashSet<>();
        for (String number : inputMainNumbers.split(",")) {
            set.add(Integer.parseInt(number));
        }
        set.add(Integer.parseInt(inputBonusNumber));
        if (set.size() != Rule.COUNT + 1) {
            throw new IllegalArgumentException(DUPLICATION.message);
        }
    }

    private void moneyCharacterCheck(String money) {
        for (char character : money.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException(WRONG_MONEY.message);
            }
        }
    }

    private void checkAmountOfMoney(String money) {
        if(Integer.parseInt(money) % 1000 != 0 || Integer.parseInt(money) == 0) {
            throw new IllegalArgumentException(WRONG_MONEY.message);
        }
    }
}