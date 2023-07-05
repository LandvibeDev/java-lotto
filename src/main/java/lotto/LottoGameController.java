package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    private List<Integer> generateOne() {
        List<Integer> lotto = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int number = Randoms.pickNumberInRange(1, 45);
            while (lotto.contains(number)) {
                number = Randoms.pickNumberInRange(1, 45);
            }
            lotto.add(number);
        }

        return lotto;
    }

    private ArrayList<Lotto> generateLottoList(int money) {
        ArrayList<Lotto> lottoList = new ArrayList<>();

        int count = money / 1000;
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generateOne());
        }
        return lottoList;
    }

    private int readInputMoney() throws IllegalArgumentException {
        try {
            int money = Integer.parseInt(Console.readLine());
            return money;
        } catch (NumberFormatException numberFormatException) {
            // 에러 message 출력
            throw new IllegalArgumentException();
        }
    }

    private void checkValidMoney(int money) throws IllegalArgumentException {
        if (money % 1000 != 0) {
            // 에러 message 출력
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        int money = readInputMoney();
        checkValidMoney(money);

        ArrayList<Lotto> lottoList = generateLottoList(money);
    }
}
