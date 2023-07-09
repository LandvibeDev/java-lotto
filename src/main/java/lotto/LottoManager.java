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
            Lotto lottoOneSet = issueLottoOneSet();
            myLotto.lottoSet.add(lottoOneSet);
        }
    }

    private Lotto issueLottoOneSet() {
        List<Integer> lottoOneList = new ArrayList<>();
        while(lottoOneList.size() < Number.Rule.SIZE.toNumber()) {
            int newNumber = Randoms.pickNumberInRange(Number.Rule.MIN.toNumber(), Number.Rule.MAX.toNumber());
            if(lottoOneList.contains(newNumber)) {
                continue;
            }
            lottoOneList.add(newNumber);
        }
        return new Lotto(lottoOneList);
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

    // TODO: - 유효성 체크
    private void validatePurchaseMoney(String money) {

    }

    private void validateWinnerString(String input) {

    }

    private void validateBonusNumber(String input) {

    }
}
