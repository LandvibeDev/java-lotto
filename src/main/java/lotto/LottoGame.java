package lotto;

import calculator.*;
import camp.nextstep.edu.missionutils.Console;
import numberManager.LottoList;
import numberManager.WinningNumbers;

import static validator.ExceptionController.*;

public class LottoGame {
    private LottoList lottoList;
    private WinningNumbers winningNumbers;
    int coin;

    LottoGame(){
        String amount = inputAmount();

        try {
            noIntegerValueException(amount);
            noValidAmountException(amount);
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return;
        }

        coin = Integer.parseInt(amount)/1000;
    }

    private String inputAmount(){
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
        String amount = Console.readLine();
        return amount;
    }

    public void run(){
        lottoList = new LottoList(coin);
        winningNumbers = new WinningNumbers();

        Calculator calculator = new Calculator(lottoList, winningNumbers);
        calculator.totalCorrectCount();
        calculator.printResult();
        calculator.printIncomeRate(coin);
    }
}
