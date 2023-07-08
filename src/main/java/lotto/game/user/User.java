package lotto.game.user;

public class User {
    private static User instance;

    private User(){
        refund = 0;
    }

    public static User getInstance(){
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    private int refund;

    public void updateRefund(int plus){
        refund += plus;
    }
    public int getRefund(){
        return refund;
    }
}
