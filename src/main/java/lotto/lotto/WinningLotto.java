package lotto.lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;
    public WinningLotto(Lotto lotto, int bonus){
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
