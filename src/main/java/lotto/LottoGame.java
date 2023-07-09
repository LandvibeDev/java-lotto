package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.ConsoleMessages.*;
import static lotto.Parsing.parseInput;

public class LottoGame implements NumberGame {

    List<Lotto> lottoList;
    List<Result> resultList;
    WinningNumbers winningNumbers;
    int money;
    int lottoCount;
    int prize;
    Validation validation;

    public LottoGame() {
        winningNumbers = new WinningNumbers();
        resultList = new ArrayList<>();
        lottoList = new ArrayList<>() ;
        validation = new Validation();
        prize = 0;
    }

    public void play() {
        insertMoney();
        buyLotto();
        getWinningNumbers();
        calculateResult();
        getResult();
    }

    private void insertMoney() {
        printEnterMoney();
        String moneyString = Console.readLine();
        validation.validateMoney(moneyString);
        money = Parsing.parseMoney(moneyString);
        lottoCount = money / 1000;
        printLottoCount(lottoCount);
    }

    private void buyLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> randomNumbers;
        for(int count = 0; count <lottoCount; count++) {
            randomNumbers = randomNumberGenerator.generateRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lottoList.add(lotto);
        }
        printLottoNumbers();
    }

    private void printLottoNumbers() {
        for (Lotto lotto : lottoList) {
            ConsoleMessages.printLottoNumbers(lotto);
        }
    }

    public void getWinningNumbers() {
        String mainNumbers = getMainNumbers();
        String bonusNumber = getBonusNumber();
        validation.validateWinningNumbers(mainNumbers, bonusNumber);
        parseWinningNumbers(mainNumbers, bonusNumber);
    }

    private String getMainNumbers() {
        printEnterWinningNumber();
        String mainNumbers = Console.readLine();
        return mainNumbers;
    }

    private String getBonusNumber() {
        printEnterBonusNumber();
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    private void parseWinningNumbers(String inputMainNumbers, String inputBonusNumber) {
        winningNumbers = parseInput(inputMainNumbers, inputBonusNumber);
    }

    private void calculateResult() {
        for (Lotto lotto : lottoList) {
             MatchedNumbers matchedNumbers = lotto.match(winningNumbers);
             resultList.add(matchedNumbers.computeResult());
        }
    }

    private List<Integer> makeRankArrayList() {
        List<Integer> rankArrayList = new ArrayList<>();
        for(int count = 0; count <= Rule.MIN_RANK; count++) { // 최소 등수(5)등의 사이즈를 갖도록 하는 것
            rankArrayList.add(0);
        }
        return rankArrayList;
    }

    private void getResult() {
        List<Integer> rankArrayList = makeRankArrayList();
        for (Result result : resultList) {
            rankArrayList.set(result.order-1, rankArrayList.get(result.order-1)+1);
            prize += result.prize;
        }
        printResult(rankArrayList);
        printEarningRate(calculateEarningsRate());
    }

    private double calculateEarningsRate() {

        return ((double)prize / money) * 100;
    }
}
