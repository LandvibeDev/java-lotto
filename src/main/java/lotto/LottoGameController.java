package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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
            System.out.println("구입금액을 입력해 주세요.");
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
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    private int readInputBonusNumber() throws IllegalArgumentException {
        System.out.println("\n보너스 번호를 입력해 주세요.");

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

    public void printLottoList(ArrayList<Lotto> lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public Score calculate(ArrayList<Lotto> lottoList, Lotto winningLotteryNumber, int bonusNumber, int money) {
        List<Integer> winningNumbers = winningLotteryNumber.getNumbers();
        List<Integer> counts = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();
            int count = 0;

            for (Integer num : numbers) {
                if (winningNumbers.contains(num))
                    count++;
            }
            if (count >= 3) {
                counts.add(count);
            }
        }
        return new Score(counts, money);
    }

    public void play() {
        int money = readInputMoney();
        checkValidMoney(money);

        ArrayList<Lotto> lottoList = generateLottoList(money);
        printLottoList(lottoList);

        String winningLotteryStr = readInputWinningLotteryNumber();
        Lotto winningLotteryNumber = generateWinningLotteryNumber(winningLotteryStr);

        int bonusNumber = readInputBonusNumber();
        Score score = calculate(lottoList, winningLotteryNumber, bonusNumber, money);
        System.out.println(score.toString());
    }
}
