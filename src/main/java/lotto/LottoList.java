package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoList {
    Lotto[] lottos;
    int coin;
    LottoList(int coin){
        this.coin = coin;
        this.lottos = new Lotto[coin];
    }

    public void setLottoList() {
        for (int i = 0; i < coin; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos[i] = new Lotto(numbers);
            System.out.println(lottos[i].toString());
        }
    }
}
