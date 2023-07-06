package lotto.game.result;

public class Count {
    private int cnt;
    private int bonusCnt;


    public Count(){
        cnt = 0;
        bonusCnt = 0;
    }

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
    public void loadAwards(){
        this.bonusCnt++;
    }

    public int getCnt() {
        return cnt;
    }
    public int getBonusCnt() {
        return bonusCnt;
    }
}
