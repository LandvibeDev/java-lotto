package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.number.Lotto;
import lotto.number.NumberManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameController implements GameController {

    private final NumberManager numberManager;

    public LottoGameController(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    @Override
    public String readInput(String message) {
        System.out.println(message);

        String input = Console.readLine();
        return input;
    }

    public int checkValidMoney(String moneyString) throws IllegalArgumentException {
        int money;
        try {
            money = Integer.parseInt(moneyString);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR]" + " 정수를 입력하세요."); // error enum class 만들기
        } // NumberValidator - interface - 여기 따로 빼기

        if (money % 1000 != 0) { // (로또 가격) -> enum
            throw new IllegalArgumentException("[ERROR]" + "  1000원 단위로 구입 금액을 입력하세요.");
        } // 구체 클래스에 구현 ? - dip 깨지는데 ..
        return money;
    }

    //parseInput 클래스로 바꾸기 + valid 따로 빼기
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

    // readInput으로 바꾸고, 숫자로 변환하는 함수로 하나 따로 빼고, valid 로직 따로 빼기
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

    //numberManager - interface - 비교대상, int ...
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
        String moneyStr;
        moneyStr = readInput("구입금액을 입력해 주세요.");

        int money;
        try {
            money = checkValidMoney(moneyStr);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return;
        }

        List<Lotto> lottoList = numberManager.generateList(1, 45, 6, money / 1000); // enum
        printLottoList(lottoList);

        String winningLotteryStr = readInput("\n당첨 번호를 입력해 주세요.");
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
