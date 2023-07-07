package lotto.compare;

import java.util.List;

public interface Compare {
    public List<Integer> compare();

    public int[] winCount(List<Integer> list);
}
