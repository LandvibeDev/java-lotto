package lotto;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.Result.*;
import static lotto.Rule.*;

public class ConsoleMessages {

    public static void printResult(List<Integer> resultNumber) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (%s원) - %d개", decFormat.format(FIFTH.prize) ,resultNumber.get(MIN_RANK-1)));
        System.out.println(String.format("4개 일치 (%s원) - %d개", decFormat.format(FOURTH.prize), resultNumber.get(MIN_RANK-2)));
        System.out.println(String.format("5개 일치 (%s원) - %d개", decFormat.format(THIRD.prize), resultNumber.get(MIN_RANK-3)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개", decFormat.format(SECOND.prize), resultNumber.get(MIN_RANK-4)));
        System.out.println(String.format("6개 일치 (%s원) - %d개", decFormat.format(FIRST.prize), resultNumber.get(MIN_RANK-5)));
    }

    public static void printEarningRate(double earningRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", earningRate));
    }

    public static void printEnterMoney() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }

    public static void printEnterWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public static void printEnterBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.toString());
    }

}
