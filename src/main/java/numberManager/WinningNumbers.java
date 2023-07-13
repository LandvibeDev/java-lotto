package numberManager;

import camp.nextstep.edu.missionutils.Console;
import static validator.ExceptionController.*;

import static lotto.Message.*;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    public List<Integer> winningNumberslist = new ArrayList<>();
    public int bonusNumber;
    public String winningNumbers;

    public WinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        winningNumbers = Console.readLine();
        setWinningNumberslist();
        setBonusNumber();
    }
    private void setWinningNumberslist(){
        String correctString = "";

        for(int i=0; i<winningNumbers.length(); i++){
            char tmp = winningNumbers.charAt(i);
            if(tmp == ',') {
                putCorrectNumber(correctString);
                correctString = "";
                continue;
            }
            correctString += tmp;
        }

        putCorrectNumber(correctString);
    }

    private void putCorrectNumber(String correctString){
        int correctInteger = Integer.parseInt(correctString);

        try {
            noIntegerValueException(correctString);
            noValidLottoNumberException(correctInteger);
            overlapNumberException(winningNumberslist, correctInteger);
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

        winningNumberslist.add(correctInteger);
    }

    private void setBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        String bonusNumberstr = Console.readLine();
        int bonusNumberint = Integer.parseInt(bonusNumberstr);

        noIntegerValueException(bonusNumberstr);
        noValidLottoNumberException(bonusNumberint);
        overlapNumberException(winningNumberslist, bonusNumberint);

        bonusNumber = bonusNumberint;
    }
}
