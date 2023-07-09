package lotto;

public class ResultLottoData {
    public int threeMatchCount;
    public int fourMatchCount;
    public int fiveMatchCount;
    public int fiveAndBonusMatchCount;
    public int sixMatchCount;
    public int totalProfit;
    public double rate;

    public ResultLottoData() {
        threeMatchCount = 0;
        fourMatchCount = 0;
        fiveMatchCount = 0;
        fiveAndBonusMatchCount = 0;
        sixMatchCount = 0;
        totalProfit = 0;
        rate = 0.0;
    }

    public void update(int numOfLottoMatches, boolean isMatchWithBonus) {
        if(numOfLottoMatches == 3) {
            threeMatchCount++;
            return;
        }
        if(numOfLottoMatches == 4) {
            fourMatchCount++;
            return;
        }
        if(numOfLottoMatches == 5) {
            if(isMatchWithBonus) {
                fiveAndBonusMatchCount++;
                return;
            }
            fiveMatchCount++;
            return;
        }
        if(numOfLottoMatches == 6) {
            sixMatchCount++;
            return;
        }
    }

    public void calculateProfit() {
        totalProfit = threeMatchCount * Number.Prize.THREE_MATCH.toNumber()
                + fourMatchCount * Number.Prize.FOUR_MATCH.toNumber()
                + fiveMatchCount * Number.Prize.FIVE_MATCH.toNumber()
                + fiveAndBonusMatchCount * Number.Prize.FIVE_BONUS_MATCH.toNumber()
                + sixMatchCount * Number.Prize.SIX_MATCH.toNumber();
    }

    public void calculateRate(int purchaseMoney) {
        double rate = (this.totalProfit / purchaseMoney) * 100;
        this.rate = Math.round(rate * 100.0) / 100.0;
    }
}