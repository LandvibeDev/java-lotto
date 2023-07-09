package lotto;

import java.util.ArrayList;
import java.util.List;

public class MyLottoData {
    public int money;
    public int quantity;
    public List<Lotto> lottoSet;

    public MyLottoData() {
        money = 0;
        quantity = 0;
        lottoSet = new ArrayList<>();
    }
}
