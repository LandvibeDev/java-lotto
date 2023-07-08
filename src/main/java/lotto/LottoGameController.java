package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.number.Lotto;
import lotto.number.NumberManager;

import java.util.List;

public class LottoGameController implements GameController {

    private final NumberManager numberManager;

    public LottoGameController(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    @Override
    public void play() {
        println(Constants.Message.PURCHASE);

        int money;
        try {
            money = readMoney();
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return;
        }

        List<Lotto> lottoList;
        lottoList = makeLottoList(Constants.NumberRange.START, Constants.NumberRange.END, Constants.NumberRange.COUNT, money);
        printLottoList(lottoList, lottoList.size() + Constants.Message.PURCHASE_COMPLETE);

        println(Constants.Message.ANSWER_LOTTO);
        Lotto answerLotto;
        try {
            answerLotto = makeAnswerLotto();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return;
        }

        println(Constants.Message.BONUS);
        int bonus;
        try {
            bonus = readBonus(answerLotto.getNumbers());
        } catch (IllegalArgumentException illegalArgumentException) {
            println(illegalArgumentException.getMessage());
            return;
        }

        makeScore(lottoList, answerLotto, bonus, money);
    }

    public int readMoney() throws IllegalArgumentException {
        String str = Console.readLine();

        int money;
        try {
            money = numberManager.generate(str);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }

        return money;
    }

    public List<Lotto> makeLottoList(int start, int end, int count, int money) {
        List<Lotto> lottoList = numberManager.generateLists(start, end, count, money / Constants.Lotto.PRICE);
        return lottoList;
    }

    public void printLottoList(List<Lotto> list, String message) {
        println(message);

        for (Lotto lotto : list) {
            System.out.println(lotto.toString());
        }
    }

    public Lotto makeAnswerLotto() {
        String str = Console.readLine();
        String[] strings = str.split(Constants.Lotto.DELIM);

        List<Integer> list = numberManager.generateList(strings);
        return new Lotto(list);
    }

    public int readBonus(List<Integer> list) throws IllegalArgumentException {
        String str = Console.readLine();

        int bonus;
        try {
            bonus = numberManager.generateBonus(str, list);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return bonus;
    }

    public void makeScore(List<Lotto> lottoList, Lotto answerLotto, int bonus, int money) {
        List<Integer> list = numberManager.calculate(lottoList, answerLotto, bonus);
        Score score = new Score(list, money);
        System.out.println(score);
    }

    public void println(String message) {
        System.out.println(message);
    }

}
