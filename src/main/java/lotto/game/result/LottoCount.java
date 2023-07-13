package lotto.game.result;

public class LottoCount {

    private final int cnt; // 몇개 당첨인지
    private final int bonusCnt;

    public LottoCount(int cnt, int bonusCnt){
        this.cnt=cnt;
        this.bonusCnt = bonusCnt;
    }

    public int getCnt() {
        return cnt;
    }

    public int getBonusCnt() {
        return bonusCnt;
    }
}
