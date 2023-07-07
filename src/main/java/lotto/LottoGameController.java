package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameController implements GameController {

    public Lotto generateOne() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }

    public List<Lotto> generateLottoList(int money) {
        List<Lotto> lottoList = new ArrayList<>();

        int count = money / 1000;
        for (int i = 0; i < count; i++) {
            lottoList.add(generateOne());
        }

        return lottoList;
    }

    public String readInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        String inputMoneyString = Console.readLine();
        return inputMoneyString;
    }

    public int checkValidMoney(String moneyString) throws IllegalArgumentException {
        int money;
        try {
            money = Integer.parseInt(moneyString);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR]" + " 정수를 입력하세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]" + "  1000원 단위로 구입 금액을 입력하세요.");
        }
        return money;
    }

    public String readInputWinningLotteryNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    public Lotto generateWinningLotteryNumber(String winningLotteryStr) throws IllegalArgumentException {
        List<Integer> lotto = new ArrayList<>();
        String[] numbers = winningLotteryStr.split(",");

        for (String str : numbers) {
            int number;
            try {
                number = Integer.parseInt(str);
            } catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException();
            }

            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }

            if (!lotto.contains(number)) {
                lotto.add(number);
            }
        }
        return new Lotto(lotto);
    }

    public int readInputBonusNumber(List<Lotto> lottoList) throws IllegalArgumentException {
        System.out.println("\n보너스 번호를 입력해 주세요.");

        int bonus;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException();
        }

        if (lottoList.contains(bonus)) {
            throw new IllegalArgumentException();
        }

        return bonus;
    }

    public void printLottoList(List<Lotto> lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public Score calculate(List<Lotto> lottoList, Lotto winningLotteryNumber, int bonusNumber, int money) {
        List<Integer> winningNumbers = winningLotteryNumber.getNumbers();
        ArrayList<Integer> counts = new ArrayList<>(Collections.nCopies(10, 0));

        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();
            int count = 0;

            for (Integer num : numbers) {
                if (winningNumbers.contains(num))
                    count++;
            }

            if (count == 5) {
                int bonusIndex = 0;
                if (winningNumbers.contains(bonusNumber)) {
                    counts.set(bonusIndex, counts.get(bonusIndex) + 1);
                }
                continue;
            }

            if (count >= 3) {
                counts.set(count, counts.get(count) + 1);
            }
        }

        return new Score(counts, money);
    }

    @Override
    public void play() {
        String moneyString;
        moneyString = readInputMoney();

        int money;
        try {
            money = checkValidMoney(moneyString);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return;
        }

        List<Lotto> lottoList = generateLottoList(money);
        printLottoList(lottoList);

        String winningLotteryStr = readInputWinningLotteryNumber();
        Lotto winningLotteryNumber;

        try {
            winningLotteryNumber = generateWinningLotteryNumber(winningLotteryStr);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR]" + "1~45 사이의 정수를 입력하세요. generateWinningLotteryNumber error");
            return;
        }

        int bonusNumber;
        try {
            bonusNumber = readInputBonusNumber(lottoList);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR]" + " 중복되지 않는 1~45 사이의 정수를 입력하세요. generateWinningLotteryNumber error");
            return;
        }

        Score score = calculate(lottoList, winningLotteryNumber, bonusNumber, money);
        System.out.println(score.toString());
    }

}
