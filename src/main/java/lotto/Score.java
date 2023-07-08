package lotto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class Score {
    private final List<Integer> counts;
    private final int money;

    public Score(List<Integer> counts, int money) {
        this.counts = counts;
        this.money = money;
    }

    private BigDecimal calculateProfit() {
        if (money == 0)
            return new BigDecimal("0.0");

        BigDecimal profit = new BigDecimal("0.0");

        BigDecimal first = new BigDecimal(counts.get(Constants.Winning.FIRST) * Constants.Reward.FIRST_PRICE);
        BigDecimal second = new BigDecimal(counts.get(Constants.Winning.SECOND) * Constants.Reward.SECOND_PRICE);
        BigDecimal third = new BigDecimal(counts.get(Constants.Winning.THIRD) * Constants.Reward.THIRD_PRICE);
        BigDecimal fourth = new BigDecimal(counts.get(Constants.Winning.FOURTH) * Constants.Reward.FOURTH_PRICE);
        BigDecimal fifth = new BigDecimal(counts.get(Constants.Winning.FIFTH) * Constants.Reward.FIFTH_PRICE);

        profit = profit.add(first);
        profit = profit.add(second);
        profit = profit.add(third);
        profit = profit.add(fourth);
        profit = profit.add(fifth);

        BigDecimal money = new BigDecimal(this.money);
        BigDecimal percent = new BigDecimal(100);

        profit = profit.divide(money, MathContext.UNLIMITED);
        profit = profit.multiply(percent);
        profit = profit.setScale(Constants.Lotto.DECIMAL_PLACE, RoundingMode.HALF_UP);

        System.out.println(profit);
        return profit;
    }

    @Override
    public String toString() {
        return "\n당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + counts.get(Constants.Winning.FIFTH) + "개\n" +
                "4개 일치 (50,000원) - " + counts.get(Constants.Winning.FOURTH) + "개\n" +
                "5개 일치 (1,500,000원) - " + counts.get(Constants.Winning.THIRD) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get(Constants.Winning.SECOND) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + counts.get(Constants.Winning.FIRST) + "개\n" +
                "총 수익률은 " + calculateProfit() + "%입니다.";
    }
}
