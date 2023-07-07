package lotto.game;

import lotto.compare.Compare;
import lotto.compare.CompareImpl;
import lotto.input.Input;
import lotto.print.Print;
import lotto.randomNumber.RandomNumber;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<List<Integer>> getRandomNumbers(int amount) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> randomNumbers = randomNumber.getRandomNumber();
            list.add(randomNumbers);
        }
        return list;
    }

    @Override
    public int[] getWinCounts(List<List<Integer>> winCounts) {
        int[] place = new int[5];
        for (List<Integer> winCount : winCounts) {
            int count = winCount.get(0);
            if (count == 6) {
                place[0]++;
                continue;
            }
            if (count == 5) {
                if (winCount.get(1) == 1) {
                    place[1]++;
                    continue;
                }
                place[2]++;
                continue;
            }
            if (count == 4) {
                place[3]++;
                continue;
            }
            if (count == 3) {
                place[4]++;
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
            ;
            winCounts.add(winCountResult);
        }
        int[] place = getWinCounts(winCounts);
        print.printResult(place, price);
    }
}
