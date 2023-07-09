package lotto;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.Result.*;
import static lotto.Rule.*;

public class ConsoleMessages {

    public static void printResult(List<Integer> resultNumber) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        String result = "당첨 통계\n";
        result += "---\n";
        result += String.format("3개 일치 (%s원) - %d개\n", decFormat.format(FIFTH.prize) ,resultNumber.get(MIN_RANK-1));
        result += String.format("4개 일치 (%s원) - %d개\n", decFormat.format(FOURTH.prize), resultNumber.get(MIN_RANK-2));
        result += String.format("5개 일치 (%s원) - %d개\n", decFormat.format(THIRD.prize), resultNumber.get(MIN_RANK-3));
        result += String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", decFormat.format(SECOND.prize), resultNumber.get(MIN_RANK-4));
        result += String.format("6개 일치 (%s원) - %d개", decFormat.format(FIRST.prize), resultNumber.get(MIN_RANK-5));
        System.out.println(result);
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
