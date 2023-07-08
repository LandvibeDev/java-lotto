package lotto.game.money;

import lotto.numbers.Prize;

public class EarnMoney {
    private long earnMoney;
    public EarnMoney(){
        earnMoney = 0;
    }

    public void addMoney(int[] prizeParam){
        earnMoney += Prize.FIRST.getValue() * prizeParam[1];
        earnMoney += Prize.SECOND.getValue()* prizeParam[2];
        earnMoney += Prize.THIRD.getValue()* prizeParam[3];
        earnMoney += Prize.FOURTH.getValue()* prizeParam[4];
        earnMoney += Prize.FIFTH.getValue()* prizeParam[5];
    }

    public long getEarnMoney() {
        return earnMoney;
    }
}
