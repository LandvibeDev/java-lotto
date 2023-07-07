package lotto;

import static lotto.Message.*;
import static lotto.Message.INPUT_BONUS;

public interface Print {
    public int printSix(int value);

    public int printFive(int value);

    public int printFiveBonus(int value);

    public int printFour(int value);

    public int printThree(int value);

    public void printProfitResultMessage(int result, int price);

    public void printAmountMessage(int amount);

    public void printGetPriceMessage();

    public void printWinningNumberMessage();

    public void printBonusNumberMessage();

    public void printResult(int[] place, int price);
}
