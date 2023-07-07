package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {


    private final RandomNumber randomNumber;
    private final Input input;
    private final Print print;


    Game(RandomNumber randomNumber, Input input, Print print) {
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

    private void calculateWinCounts(int[] place, int idx, List<int[]> winCounts) {
        if (winCounts.get(idx)[0] == 6) {
            place[0]++;
            return;
        }
        if (winCounts.get(idx)[0] == 5) {
            if (winCounts.get(idx)[1] == 1) {
                place[1]++;
                return;
            }
            place[2]++;
            return;
        }
        if (winCounts.get(idx)[0] == 4) {
            place[3]++;
            return;
        }
        if (winCounts.get(idx)[0] == 3) {
            place[4]++;
        }
    }

    private int[] getWinCounts(List<int[]> winCounts) {
        int[] place = new int[5];
        for (int i = 0; i < winCounts.size(); i++) {
            calculateWinCounts(place, i, winCounts);
        }
        return place;
    }

    public void run() {
        List<int[]> winCounts = new ArrayList<>();
        int price = input.getPurchasePrice();
        int amount = price / 1000;
        List<List<Integer>> list = getRandomNumbers(amount);
        print.printAmountMessage(amount);
        List<Integer> winningNumber = input.getWiningNumber();
        for (int i = 0; i < amount; i++) {
            Compare compare = new Compare(winningNumber, list.get(i));
            winCounts.add(compare.winCount(compare.compare()));
        }
        int[] place = getWinCounts(winCounts);
        print.printResult(place, price);
    }
}
