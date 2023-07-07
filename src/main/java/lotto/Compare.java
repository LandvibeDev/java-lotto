package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constant.DIGITS;

public interface Compare {
    public List<Integer> compare();

    public int[] winCount(List<Integer> list);
}
