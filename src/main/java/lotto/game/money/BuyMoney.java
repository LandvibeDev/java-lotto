package lotto.game.money;

import camp.nextstep.edu.missionutils.Console;

public class BuyMoney {
    private final int buyMoney;
    private final int buyCount;
    private final String inputBuyMoney;
    public BuyMoney(){
        System.out.println("구입 금액을 입력해 주세요.");
        inputBuyMoney = Console.readLine();
        for(int i = 0; i < inputBuyMoney.length(); i++){
            checkError(inputBuyMoney.charAt(i));
        }
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

    private void checkError(char input){
        if(input >= '0' && input <= '9'){
            return;
        }
        throw new IllegalArgumentException("[ERROR]숫자만 입력하세요.");
    }
}
