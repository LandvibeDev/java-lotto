package lotto.game.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.game.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class MakeNumber {
    public static List<Lotto> makeRandomLottoNumbers(int cycle, List<Lotto>lottoList) {
        for (int i = 0; i < cycle; i++) {
            // 로또 번호 생성
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            // 오름차순 정렬
            //Collections.sort(numbers);

            // 로또 객체로 만들어 로또 리스트에 넣어주기
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
