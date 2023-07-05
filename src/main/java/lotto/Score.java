package lotto;

import java.util.List;

public class Score {
    private final List<Integer> counts;
    private final int money;

    public Score(List<Integer> counts, int money) {
        this.counts = counts;
        this.money = money;
    }

    @Override
    public String toString() {
        return "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.5%입니다.";
    }

    /*    당첨 통계
---
        3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.*/
}
