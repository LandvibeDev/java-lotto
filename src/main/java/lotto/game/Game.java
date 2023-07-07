package lotto.game;

import java.util.ArrayList;
import java.util.List;

public interface Game {

    List<List<Integer>> getRandomNumbers(int amount);

    int[] getWinCounts(List<List<Integer>> winCounts);


    public void run();
}
