package calculator;

public class Printer {

    int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
    int totalIncome = 0;

    public void printResult(){
        System.out.println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + fifth + "개\n" +
                "4개 일치 (50,000원) - " + fourth + "개\n" +
                "5개 일치 (1,500,000원) - " + third + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개\n" +
                "6개 일치 (2,000,000,000원) - " + first + "개");
    }

    public void printIncomeRate(int coin){
        double incomeRateTemp = ((double)totalIncome / (double)(coin * 1000))*100;
        double incomeRate = Math.round(incomeRateTemp*100)/100.0;
        System.out.println("총 수익률은 " + incomeRate + "%입니다.");
    }
}
