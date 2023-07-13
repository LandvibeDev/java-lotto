package calculator;

import numberManager.LottoList;
import numberManager.WinningNumbers;

public class Calculator extends Printer{

    private LottoList lottoList;
    private WinningNumbers winningNumbers;

    public Calculator(LottoList lottoList, WinningNumbers winningNumbers){
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
    }

    public void totalCorrectCount(){
        for(int i=0; i<lottoList.lottos.length; i++) {
            int correctCount = lottoList.lottos[i].calculateCorrectCount(winningNumbers.winningNumberslist);
            boolean correctBonus = lottoList.lottos[i].calculateBonusNumber(winningNumbers.bonusNumber);

            countUp(correctCount, correctBonus);
        }
    }

    private void countUp(int correctCount, boolean correctBonus){
        if (correctCount == 6) {
            first++;
            totalIncome += 2000000000;
        } else if (correctCount == 5 && correctBonus == true) {
            second++;
            totalIncome += 30000000;
        } else if (correctCount == 5) {
            third++;
            totalIncome += 1500000;
        } else if (correctCount == 4) {
            fourth++;
            totalIncome += 50000;
        } else if(correctCount == 3){
            fifth++;
            totalIncome += 5000;
        }
    }
}
