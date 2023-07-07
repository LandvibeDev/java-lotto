package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    LottoList lottoList;
    WinningNumbers winningNumbers;
    int coin;

    LottoGame(){
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        ExceptionController.noIntegerValueException(amount);
        ExceptionController.noValidAmountException(amount);

        coin = Integer.parseInt(amount)/1000;
    }

    public void run(){
        lottoList = new LottoList(coin);
        winningNumbers = new WinningNumbers();
    }
}
