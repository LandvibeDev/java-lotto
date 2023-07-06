package lotto.game.user;

import lotto.game.result.Awards;

public class User {

    public int refund;

    public User(){
        refund = 0;
    }

    public void updateRefund(int plus){
        refund += plus;
    }
    public int getRefund(){
        return refund;
    }
}
