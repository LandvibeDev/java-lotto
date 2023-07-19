package lotto.print;

public interface Print {
    public int printSixMatch(int value);

    public int printFiveMatch(int value);

    public int printFiveBonusMatch(int value);

    public int printFourMatch(int value);

    public int printThreeMatch(int value);

    public void printProfitResultMessage(int result, int price);

    public void printAmountMessage(int amount);

    public void printGetPriceMessage();

    public void printWinningNumberMessage();

    public void printBonusNumberMessage();

    public void printResult(int[] place, int price);
}
