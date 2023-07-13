package numberManager;

import camp.nextstep.edu.missionutils.Console;
import static validator.ExceptionController.*;

import static lotto.LottoMessage.*;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    public List<Integer> winningNumberslist = new ArrayList<>();
    public int bonusNumber;
    private String winningNumbers;

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

        if(validate(correctString, correctInteger)) return;

        winningNumberslist.add(correctInteger);
    }

    private void setBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        String bonusNumberstr = Console.readLine();
        int bonusNumberint = Integer.parseInt(bonusNumberstr);

        if(validate(bonusNumberstr, bonusNumberint)) return;

        bonusNumber = bonusNumberint;
    }

    private boolean validate(String numStr, int numInt){
        try {
            noIntegerValueException(numStr);
            noValidLottoNumberException(numInt);
            overlapNumberException(winningNumberslist, numInt);
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }
}
