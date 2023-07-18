package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final LottoManager lottoManager;

    public GameController(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public void play() {
        System.out.println(Message.Input.PURCHASE_MONEY);
        int money = readMoney();

        int quantity = money / Number.Rule.PRICE.toNumber();
        List<Lotto> myLottoSet = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lottoOneSet = lottoManager.generate(Number.Rule.MIN.toNumber(), Number.Rule.MAX.toNumber(), Number.Rule.SIZE.toNumber());
            myLottoSet.add(lottoOneSet);
        }

        System.out.println(Message.Output.PURCHASE_QUANTITY.toQuantityFormat(quantity));
        for (Lotto lotto : myLottoSet) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println(Message.Input.WINNER_NUMBER);
        Lotto winnerNumber = readNumber();
        int bonusNumber = readBonus();

        Score score = lottoManager.calculate(myLottoSet, winnerNumber, bonusNumber);
        System.out.println(Message.Output.RESULT_STAT);
        System.out.println(score);
        System.out.println(Message.Output.RESULT_RATE.toRateFormat(score.calculateRate(money)));
    }

    private int readMoney() {
        String input = Console.readLine();
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(Message.Error.PURCHASE_AMOUNT.toString());
            }
        }
        int purchaseMoney = Integer.parseInt(input);
        if (purchaseMoney % Number.Rule.PRICE.toNumber() != 0) {
            throw new IllegalArgumentException(Message.Error.PURCHASE_AMOUNT.toString());
        }
        return Integer.parseInt(input);
    }

    private Lotto readNumber() {
        String input = Console.readLine();
        try {
            String[] stringArray = input.split(",");
            for (String str : stringArray) {
                int num = Integer.parseInt(str);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.Error.LOTTO_NUMBER.toString());
        }
        String[] stringArray = input.split(",");
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringArray) {
            int num = Integer.parseInt(str);
            integerList.add(num);
        }
        return new Lotto(integerList);
    }

    private int readBonus() {
        String input = Console.readLine();
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.Error.BONUS_NUMBER.toString());
        }
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < Number.Rule.MIN.toNumber() || bonusNumber > Number.Rule.MAX.toNumber()) {
            throw new IllegalArgumentException(Message.Error.BONUS_NUMBER.toString());
        }
        return bonusNumber;
    }
}