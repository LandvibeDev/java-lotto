package lotto.game.print;

import lotto.game.lotto.Lotto;
import lotto.game.result.Awards;
import lotto.game.result.Result;
import lotto.game.user.User;

import java.text.DecimalFormat;
import java.util.List;

public class LottoPrint implements Print{

    @Override
    public void printResultStart(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    @Override
    public void printNumberList(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            Lotto lotto = lottoList.get(i);
            System.out.println(lotto.getLottoNumber());
        }
        System.out.println();
    }
    @Override
    public void printRateOfReturn(Integer purchaseMoney, User user) {
        double percent = (double) user.getRefund() / purchaseMoney * 100;
        double roundedPercent = Math.round(percent * 10.0) / 10.0;
        System.out.println("총 수익률은 " + roundedPercent+"%입니다.");
    }

    @Override
    public void printResult(Awards awards, Result result) {
        for(int i = 3; i<=6; i++){
            String printMessage = "";
            printMessage += i+"개 일치 ";
            // 5000원
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedValue = "(" + decimalFormat.format(awards.getAwards()[i]) + "원) - ";
            printMessage += formattedValue;
            printMessage += result.getResult()[i]+"개";


            if(i==5){
                printMessage += '\n';
                printMessage += i+"개 일치, 보너스 볼 일치 ";
                formattedValue = "(" + decimalFormat.format(awards.getBonusAwards()) + "원) - ";
                printMessage+=formattedValue;
                printMessage += result.getBonusResult()+"개";
            }

            System.out.println(printMessage);
        }
    }

    @Override
    public void printPurchaseCount(int cnt){
        System.out.println(cnt + "개를 구매했습니다.");
    }
}
