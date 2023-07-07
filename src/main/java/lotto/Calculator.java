package lotto;

public class Calculator {
    LottoList lottoList;
    WinningNumbers winningNumbers;

    int countThree = 0, countFour = 0, countFive = 0, countSix = 0, countFiveAndBonus = 0;
    int totalIncome = 0;

    Calculator(LottoList lottoList, WinningNumbers winningNumbers){
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
        calculateCorrectCount();
    }

    public void calculateCorrectCount(){
        for(int i=0; i<lottoList.lottos.length; i++) {
            int correctCount = lottoList.lottos[i].calculateCorrectCount(winningNumbers.winningNumberslist);
            boolean correctBonus = lottoList.lottos[i].calculateBonusNumber(winningNumbers.bonusNumber);

            countUp(correctCount, correctBonus);
        }
    }

    private void countUp(int correctCount, boolean correctBonus){
        switch (correctCount) {
            case 3:
                countThree++;
                totalIncome += 5000;
                break;
            case 4:
                countFour++;
                totalIncome += 50000;
                break;
            case 5:
                countFive++;
                totalIncome += 1500000;
                break;
            case 6:
                countSix++;
                totalIncome += 2000000000;
                break;

        }

        if(correctCount == 6 && correctBonus == true){
            countFiveAndBonus++;
            totalIncome += 30000000;
        }
    }

    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countThree + "개");
        System.out.println("4개 일치 (50,000원) - " + countFour + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countFive + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countFiveAndBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countSix + "개");
    }

    public void printIncomeRate(int coin){
        double incomeRateTemp = ((double)totalIncome / (double)(coin * 1000))*100;
        double incomeRate = Math.round(incomeRateTemp*100)/100.0;
        System.out.println("총 수익률은 " + incomeRate + "%입니다.");
    }
}
