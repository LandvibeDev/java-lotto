package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        LottoGame lottoGame = new LottoGame();
        lottoGame.run();

        /*
        //보너스 번호 입력(+예외처리)
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberStr = Console.readLine();
        for(int i=0; i<bonusNumberStr.length(); i++){
            char tmp = bonusNumberStr.charAt(i);
            if(tmp-'0'<0 || tmp-'0'>9){
                System.out.println("[ERROR]");
                throw new IllegalArgumentException();
            }
        }

        int bonusNumber = Integer.parseInt(bonusNumberStr);

        if(bonusNumber<1 || bonusNumber>45){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }

        if(correctNumberslist.contains(bonusNumber)){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }

        //당첨 통계 계산
        int countThree = 0, countFour = 0, countFive = 0, countSix = 0, countFiveAndBonus = 0;
        int totalIncome = 0;
        for(int i=0; i<coin; i++){
            int correctCount = lottos[i].calculateCorrectCount(correctNumberslist);
            boolean correctBonus = lottos[i].calculateBonusNumber(bonusNumber);

            switch (correctCount){
                case 3: countThree++;
                        totalIncome += 5000;
                        break;
                case 4: countFour++;
                        totalIncome += 50000;
                        break;
                case 5: countFive++;
                        totalIncome += 1500000;
                        break;
                case 6: countSix++;
                        totalIncome += 2000000000;
                        break;
            }

            if(correctCount == 6 && correctBonus == true){
                countFiveAndBonus++;
                totalIncome += 30000000;
            }
        }

        //당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countThree + "개");
        System.out.println("4개 일치 (50,000원) - " + countFour + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countFive + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countFiveAndBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countSix + "개");

        //총 수익률 출력
        double incomeRateTemp = ((double)totalIncome / (double)(coin * 1000))*100;
        double incomeRate = Math.round(incomeRateTemp*100)/100.0;
        System.out.println("총 수익률은 " + incomeRate + "%입니다.");
         */
    }

}

