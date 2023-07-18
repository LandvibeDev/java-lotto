package lotto;

public class Score {
    private final int threeMatchCount, fourMatchCount,
            fiveMatchCount, fiveAndBonusMatchCount, sixMatchCount;

    public Score(int threeMatchCount, int fourMatchCount,
                 int fiveMatchCount, int fiveAndBonusMatchCount, int sixMatchCount) {
        this.threeMatchCount = threeMatchCount;
        this.fourMatchCount = fourMatchCount;
        this.fiveMatchCount = fiveMatchCount;
        this.fiveAndBonusMatchCount = fiveAndBonusMatchCount;
        this.sixMatchCount = sixMatchCount;
    }

    public double calculateRate(int purchaseMoney) {
        double money = purchaseMoney;
        int totalProfit = threeMatchCount * Number.Prize.THREE_MATCH.toNumber()
                + fourMatchCount * Number.Prize.FOUR_MATCH.toNumber()
                + fiveMatchCount * Number.Prize.FIVE_MATCH.toNumber()
                + fiveAndBonusMatchCount * Number.Prize.FIVE_BONUS_MATCH.toNumber()
                + sixMatchCount * Number.Prize.SIX_MATCH.toNumber();
        return (totalProfit / money) * 100.0;
    }

    @Override
    public String toString() {
        return String.format(Message.Output.RESULT_CONTENTS.toString(),
                    Number.Prize.THREE_MATCH.toDecimalFormat(), threeMatchCount,
                    Number.Prize.FOUR_MATCH.toDecimalFormat(), fourMatchCount,
                    Number.Prize.FIVE_MATCH.toDecimalFormat(), fiveMatchCount,
                    Number.Prize.FIVE_BONUS_MATCH.toDecimalFormat(), fiveAndBonusMatchCount,
                    Number.Prize.SIX_MATCH.toDecimalFormat(), sixMatchCount);
    }
}
