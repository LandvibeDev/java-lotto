package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    private Lotto generateOne() {
        List<Integer> lotto = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int number = Randoms.pickNumberInRange(1, 45);
            while (lotto.contains(number)) {
                number = Randoms.pickNumberInRange(1, 45);
            }
            lotto.add(number);
        }

        return new Lotto(lotto);
    }

    private ArrayList<Lotto> generateLottoList(int money) {
        ArrayList<Lotto> lottoList = new ArrayList<>();

        int count = money / 1000;
        for (int i = 0; i < count; i++) {
            lottoList.add(generateOne());
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

    private String readInputWinningLotteryNumber() {
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    private int readInputBonusNumber() throws IllegalArgumentException {
        try {
            int bonus = Integer.parseInt(Console.readLine());
            return bonus;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto generateWinningLotteryNumber(String winningLotteryStr) {
        List<Integer> lotto = new ArrayList<>();

        String[] numbers = winningLotteryStr.split(",");

        for (String str : numbers) {
            try {
                int number = Integer.parseInt(str);
                if (!lotto.contains(number)) {
                    lotto.add(number);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException();
            }
        }

        return new Lotto(lotto);
    }

    public void play() {
        int money = readInputMoney();
        checkValidMoney(money);

        ArrayList<Lotto> lottoList = generateLottoList(money);

        String winningLotteryStr = readInputWinningLotteryNumber();
        Lotto winningLotteryNumber = generateWinningLotteryNumber(winningLotteryStr);

        int bonusNumber = readInputBonusNumber();


    }
}
