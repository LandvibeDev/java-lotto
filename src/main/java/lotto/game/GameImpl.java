package lotto.game;

import lotto.compare.Compare;
import lotto.compare.CompareImpl;
import lotto.constant.Constant;
import lotto.input.Input;
import lotto.print.Print;
import lotto.randomNumber.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constant.*;

public class GameImpl implements Game {


    private final RandomNumber randomNumber;
    private final Input input;
    private final Print print;
    private Compare compare;


    public GameImpl(RandomNumber randomNumber, Input input, Print print) {
        this.randomNumber = randomNumber;
        this.input = input;
        this.print = print;
    }


    private List<List<Integer>> getRandomNumbers(int amount) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> randomNumbers = randomNumber.getRandomNumber();
            list.add(randomNumbers);
        }
        return list;
    }


    private int[] getWinCounts(List<List<Integer>> winCounts) {
        int[] place = new int[TOTAL_PLACES];
        for (List<Integer> winCount : winCounts) {
            int count = winCount.get(MATCH_COUNT_IDX);//보너스 숫자 제외 맞춘 숫자 갯수
            if (count == FIRST_PLACE_COUNT) {
                place[FIRST_PLACE_IDX]++;
                continue;
            }
            if (count == SECOND_PLACE_COUNT) {
                if (winCount.get(BONUS_MATCH_COUNT_IDX) == BONUS_COUNT) {//보너스 숫자 맞춘 갯수
                    place[SECOND_PLACE_IDX]++;
                    continue;
                }
                place[THIRD_PLACE_IDX]++;
                continue;
            }
            if (count == FOURTH_PLACE_COUNT) {
                place[FOURTH_PLACE_IDX]++;
                continue;
            }
            if (count == FIFTH_PLACE_COUNT) {
                place[FIFTH_PLACE_IDX]++;
            }
        }
        return place;
    }

    @Override
    public void run() {
        List<List<Integer>> winCounts = new ArrayList<>();
        int price = input.getPurchasePrice();
        int amount = price / 1000;
        List<List<Integer>> randomNumberList = getRandomNumbers(amount);
        print.printAmountMessage(amount);
        List<Integer> winningNumber = input.getWiningNumber();
        for (List<Integer> randomNumber : randomNumberList) {
            compare = new CompareImpl(winningNumber, randomNumber);
            List<Integer> winCountResult = compare.compare();
            winCounts.add(winCountResult);
        }
        int[] place = getWinCounts(winCounts);
        print.printResult(place, price);
    }
}
