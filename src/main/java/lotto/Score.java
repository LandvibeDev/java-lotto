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

        BigDecimal profit = new BigDecimal("0");

        BigDecimal first = new BigDecimal(counts.get(6) * 2000000000);
        BigDecimal bonus = new BigDecimal(counts.get(0) * 30000000);
        BigDecimal second = new BigDecimal(counts.get(5) * 1500000);
        BigDecimal third = new BigDecimal(counts.get(4) * 50000);
        BigDecimal fourth = new BigDecimal(counts.get(3) * 5000);

        profit = profit.add(first);
        profit = profit.add(bonus);
        profit = profit.add(second);
        profit = profit.add(third);
        profit = profit.add(fourth);

        BigDecimal money = new BigDecimal(this.money);
        BigDecimal percent = new BigDecimal(100);

        profit = profit.divide(money, MathContext.UNLIMITED);
        profit = profit.multiply(percent);
        profit = profit.setScale(1, RoundingMode.HALF_UP);

        System.out.println(profit);
        return profit;
    }

    @Override
    public String toString() {
        return "\n당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + counts.get(3) + "개\n" +
                "4개 일치 (50,000원) - " + counts.get(4) + "개\n" +
                "5개 일치 (1,500,000원) - " + counts.get(5) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get(0) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + counts.get(6) + "개\n" +
                "총 수익률은 " + calculateProfit() + "%입니다.";
    }
}
