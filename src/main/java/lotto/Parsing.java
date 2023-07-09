package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.ErrorMessage.*;

public class Parsing {

    public static WinningNumbers parseInput(String mainNumbersString, String bonusNumberString) {
        WinningNumbers winningNumbers = new WinningNumbers();
        winningNumbers.mainNumbers = parseMainNumbers(mainNumbersString);
        winningNumbers.bonusNumber = parseBonusNumber(bonusNumberString);
        return winningNumbers;
    }

    private static List<Integer> parseMainNumbers(String inputString) {
        List<Integer> parsedNumbers = new ArrayList<>();
        String[] parsedString = inputString.split(",");
        for (String s : parsedString) {
            int parsedNumber = Integer.parseInt(s);
            if(parsedNumber < 1 || parsedNumber > 45) {
                throw new IllegalArgumentException(WRONG_CHARACTER.message);
            }
            parsedNumbers.add(parsedNumber);
        }
        return parsedNumbers;
    }

    private static int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public static int parseMoney(String money) {
        return Integer.parseInt(money);
    }
}
