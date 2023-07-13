package lotto.game.print;

import lotto.game.lotto.Lotto;
import lotto.game.result.LottoCount;

import java.text.DecimalFormat;
import java.util.List;
import static lotto.game.constant.NumberRange.*;

public class LottoPrint implements Print{

    private final int[] awards = new int[10];

    @Override
    public void printResultStart(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    @Override
    public void printNumberList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getLottoNumber());
        }
        System.out.println();
    }
    @Override
    public void printRateOfReturn(Integer purchaseMoney, Integer rewards) {
        double percent = (double) rewards / purchaseMoney * 100;
        double roundedPercent = Math.round(percent * 10.0) / 10.0;
        System.out.println("총 수익률은 " + roundedPercent+"%입니다.");
    }

    @Override
    public void printResult(List<LottoCount>lottoCountList){
        awards[3]=5000;
        awards[4]=50000;
        awards[5]=1500000;
        awards[6]=2000000000;
        int bonusAwards = 30000000;

        int[] result = new int[10];
        int[] bonusResult = new int[10];

        for(LottoCount lottoCount : lottoCountList){
            int cnt = lottoCount.getCnt();
            int bonusCnt = lottoCount.getBonusCnt();

            result[cnt]++;
            if(bonusCnt==1){
                bonusResult[cnt]++;
            }
        }
        for(int i = RESULT_START.value(); i<= RESULT_END.value(); i++){
            String printMessage = "";
            printMessage += i+"개 일치 ";
            // 5000원
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedValue = "(" + decimalFormat.format(awards[i]) + "원) - ";
            printMessage += formattedValue;
            printMessage += result[i]+"개";


            if(i==5){
                printMessage += '\n';
                printMessage += i+"개 일치, 보너스 볼 일치 ";
                formattedValue = "(" + decimalFormat.format(bonusAwards) + "원) - ";
                printMessage+=formattedValue;
                printMessage += bonusResult[i]+"개";
            }

            System.out.println(printMessage);
        }
    }


    @Override
    public void printPurchaseCount(int cnt){
        System.out.println(cnt + "개를 구매했습니다.");
    }
}
