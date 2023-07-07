package lotto;

import java.util.ArrayList;
import java.util.List;

public interface Game {

    List<List<Integer>> getRandomNumbers(int amount);

    void calculateWinCounts(int[] place, int idx, List<int[]> winCounts);

    int[] getWinCounts(List<int[]> winCounts);

    public void run();
}
