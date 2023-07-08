package lotto.game.result;

public class Count {
    private static Count instance;

    private Count() {
        this.cnt = 0;
        this.bonusCnt = 0;
    }

    public static Count getInstance() {
        if (instance == null) {
            instance = new Count();
        }
        return instance;
    }
    private int cnt;
    private int bonusCnt;

    public void reset(){
        cnt = 0;
        bonusCnt = 0;
    }
    public void countUp(){
        this.cnt++;
    }
    public void countUpBonus(){
        this.bonusCnt++;
    }

    public int getCnt() {
        return cnt;
    }
    public int getBonusCnt() {
        return bonusCnt;
    }
}
