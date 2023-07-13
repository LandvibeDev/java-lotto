package numberManager;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoList {
    public Lotto[] lottos;

    public LottoList(int coin){
        System.out.println(coin + "개를 구매했습니다.");

        this.lottos = new Lotto[coin];
        setLottoList(coin);
    }

    public void setLottoList(int coin) {
        for (int i = 0; i < coin; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos[i] = new Lotto(numbers);
            System.out.println(lottos[i].toString());
        }
    }
}
