package lotto.number;

import java.util.List;

public interface NumberManager {
    Lotto generate(int start, int end, int count);

    List<Lotto> generateList(int start, int end, int count, int listSize);
}
