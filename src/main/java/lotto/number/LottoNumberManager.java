package lotto.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberManager implements NumberManager {

    @Override
    public Lotto generate(int start, int end, int count) {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(start, end, count);
        return new Lotto(lotto);
    }

    @Override
    public List<Lotto> generateList(int start, int end, int count, int listSize) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(generate(start, end, count));
        }
        return list;
    }

}
