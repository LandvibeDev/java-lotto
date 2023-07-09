package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private MyLottoData myLotto;
    private WinnerLottoData winnerLotto;
    private ResultLottoData resultLotto;

    public LottoManager() {
        myLotto = new MyLottoData();
        winnerLotto = new WinnerLottoData();
        resultLotto = new ResultLottoData();
    }

    public void play() {
        inputPurchaingMoney();
        issueLottoMultiSet();
        printPurchasedLotto();
        inputWinnerNumber();
        inputBonusNumber();
        calculateResultLotto();
        printResultLotto();
    }

    private void inputPurchaingMoney() {
        System.out.println(Message.Input.PURCHASE_MONEY);
        String input = Console.readLine();
        validatePurchaseMoney(input);
        int money = Integer.parseInt(input);
        myLotto.money = money;
    }

    private void issueLottoMultiSet() {
        myLotto.quantity = myLotto.money / Number.Rule.PRICE.toNumber();
        while(myLotto.lottoSet.size() < myLotto.quantity) {
            List<Integer> lottoOneList = Randoms.pickUniqueNumbersInRange(Number.Rule.MIN.toNumber(), Number.Rule.MAX.toNumber(), Number.Rule.SIZE.toNumber());
            Lotto lottoOneSet = new Lotto(lottoOneList);
            myLotto.lottoSet.add(lottoOneSet);
        }
    }

    private void printPurchasedLotto() {
        System.out.println(Message.Output.PURCHASE_QUANTITY.toQuantityFormat(myLotto.quantity));
        for(Lotto lotto : myLotto.lottoSet) {
            System.out.println(lotto.getNumbers());
        }
    }

    private void inputWinnerNumber() {
        System.out.println(Message.Input.WINNER_NUMBER);
        String winnerString = Console.readLine();
        validateWinnerString(winnerString);
        winnerLotto.parseWinnerNumber(winnerString);
    }

    private void inputBonusNumber() {
        System.out.println(Message.Input.BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        winnerLotto.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void calculateResultLotto() {
        for (Lotto lottoOneSet : myLotto.lottoSet) {
            int matchCount = countNumberOfLottoMatches(lottoOneSet);
            boolean isBonusMatch = isMatchWithBonusNumber(lottoOneSet);
            resultLotto.update(matchCount, isBonusMatch);
        }
        resultLotto.calculateProfit();
        resultLotto.calculateRate(myLotto.money);
    }

    private int countNumberOfLottoMatches(Lotto lottoOneSet) {
        int matchCount = 0;
        for (int number : lottoOneSet.getNumbers()) {
            if (winnerLotto.number.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isMatchWithBonusNumber(Lotto lottoOneSet) {
        return lottoOneSet.getNumbers().contains(winnerLotto.bonusNumber);
    }

    private void printResultLotto() {
        System.out.println(Message.Output.RESULT_STAT);
        System.out.println(Message.Output.RESULT_CONTENTS.toContentsFormat(resultLotto));
        System.out.println(Message.Output.RESULT_RATE.toRateFormat(resultLotto.rate));
    }

    private void validatePurchaseMoney(String input) throws IllegalArgumentException {
        for(char c : input.toCharArray()) {
            if(c < '0' || c > '9') {
                throw new IllegalArgumentException(Message.Error.PURCHASE_AMOUNT.toErrorFormat());
            }
        }
        int purchaseMoney = Integer.parseInt(input);
        if(purchaseMoney % Number.Rule.PRICE.toNumber() != 0) {
            throw new IllegalArgumentException(Message.Error.PURCHASE_AMOUNT.toErrorFormat());
        }
    }

    private void validateWinnerString(String input) {
        try {
            String[] stringArray = input.split(",");
            for (String str : stringArray) {
                int num = Integer.parseInt(str);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.Error.LOTTO_NUMBER.toErrorFormat());
        }
    }

    private void validateBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.Error.BONUS_NUMBER.toErrorFormat());
        }

        int bonusNumber = Integer.parseInt(input);
        if(bonusNumber < Number.Rule.MIN.toNumber() || bonusNumber > Number.Rule.MAX.toNumber()) {
            throw new IllegalArgumentException(Message.Error.BONUS_NUMBER.toErrorFormat());
        }
    }
}
