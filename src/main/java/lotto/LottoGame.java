package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    ExceptionController exceptionController = new ExceptionController();
    public void run(){
        int amount = getPurchaseAmount();
        LottoList lottoList = new LottoList(amount/1000);
        lottoList.setLottoList();
    }

    public int getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");

        String amount = Console.readLine();
        exceptionController.noIntegerValueExeption(amount);
        exceptionController.noValidAmount(amount);

        return Integer.parseInt(amount);
    }



}
