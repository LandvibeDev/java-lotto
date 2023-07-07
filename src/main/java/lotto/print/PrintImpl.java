package lotto.print;

import lotto.constant.Constant;

import static lotto.constant.Constant.*;
import static lotto.constant.Message.*;

public class PrintImpl implements Print {
    private static PrintImpl print;

    private PrintImpl() {
    }


    public static PrintImpl getInstance() {
        if (print == null) {
            print = new PrintImpl();
        }
        return print;
    }

    @Override
    public int printSixMatch(int value) {
        System.out.println(MATCH_SIX.getMATCHValue(value));
        return 2000000000 * value;
    }

    @Override
    public int printFiveMatch(int value) {
        System.out.println(MATCH_FIVE.getMATCHValue(value));
        return 1500000 * value;
    }

    @Override
    public int printFiveBonusMatch(int value) {
        System.out.println(MATCH_FIVE_BONUS.getMATCHValue(value));
        return 30000000 * value;
    }

    @Override
    public int printFourMatch(int value) {
        System.out.println(MATCH_FOUR.getMATCHValue(value));
        return 50000 * value;
    }

    @Override
    public int printThreeMatch(int value) {
        System.out.println(MATCH_THREE.getMATCHValue(value));
        return 5000 * value;
    }

    @Override
    public void printProfitResultMessage(int result, int price) {
        System.out.println(PROFIT_RESULT.getProfitValue(result, price));
    }

    @Override
    public void printAmountMessage(int amount) {
        System.out.println(+amount + OUTPUT_AMOUNT.getValue());
    }

    @Override
    public void printGetPriceMessage() {
        System.out.println(INPUT_PRICE.getValue());
    }

    @Override
    public void printWinningNumberMessage() {
        System.out.println(INPUT_NUMBER.getValue());
    }

    @Override
    public void printBonusNumberMessage() {
        System.out.println(INPUT_BONUS.getValue());
    }

    @Override
    public void printResult(int[] place, int price) {
        int result = 0;
        result += printThreeMatch(place[FIFTH_PLACE_IDX]);
        result += printFourMatch(place[FOURTH_PLACE_IDX]);
        result += printFiveMatch(place[THIRD_PLACE_IDX]);
        result += printFiveBonusMatch(place[SECOND_PLACE_IDX]);
        result += printSixMatch(place[FIRST_PLACE_IDX]);
        printProfitResultMessage(result, price);
    }

}
