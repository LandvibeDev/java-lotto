package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    LottoList lottoList;
    WinningNumbers winningNumbers;
    int coin;

    LottoGame(){
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
        String amount = Console.readLine();

        ExceptionController.noIntegerValueException(amount);
        ExceptionController.noValidAmountException(amount);

        coin = Integer.parseInt(amount)/1000;
    }

    public void run(){
        lottoList = new LottoList(coin);
        winningNumbers = new WinningNumbers();

        Calculator calculator = new Calculator(lottoList, winningNumbers);
        calculator.printResult();
        calculator.printIncomeRate(coin);
    }
}
