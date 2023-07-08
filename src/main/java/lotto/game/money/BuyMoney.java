package lotto.game.money;

import camp.nextstep.edu.missionutils.Console;
import lotto.checkexception.CheckCharException;

public class BuyMoney {
    private final int buyMoney;
    private final int buyCount;
    private final String inputBuyMoney;
    public BuyMoney(){
        System.out.println("구입 금액을 입력해 주세요.");
        inputBuyMoney = Console.readLine();
        CheckCharException checkCharException = new CheckCharException();
        checkCharException.checkCharException(inputBuyMoney);
        buyMoney = Integer.parseInt(inputBuyMoney);
        if(buyMoney % 1000 != 0){
            throw new IllegalArgumentException("[ERROR]1000원 단위로 입력해 주세요.");
        }

        buyCount = buyMoney / 1000;
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public int getBuyMoney() {
        return buyMoney;
    }
    public int getBuyCount(){
        return buyCount;
    }

}
