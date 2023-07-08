package lotto;

import camp.nextstep.edu.missionutils.Console;
import static lotto.Message.*;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumberslist = new ArrayList<>();
    int bonusNumber;
    String winningNumbers;

    WinningNumbers(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
        winningNumbers = Console.readLine();
        setWinningNumberslist();
        validate(winningNumberslist);
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
            ExceptionController.noIntegerValueException(correctString);
            if(i == winningNumbers.length()-1){
                putCorrectNumber(correctString);
            }
        }
    }

    private void putCorrectNumber(String correctString){
        int correctInteger = Integer.parseInt(correctString);

        ExceptionController.noIntegerValueException(correctString);
        ExceptionController.noValidLottoNumberException(correctInteger);
        ExceptionController.overlapNumberException(winningNumberslist, correctInteger);

        winningNumberslist.add(correctInteger);
    }

    private void validate(List<Integer> winningNumberslist) {
        if (winningNumberslist.size() != 6) {
            System.out.println(INPUT_SIXDIGIT_NUMVER);
            throw new IllegalArgumentException();
        }
    }

    private void setBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        String bonusNumberstr = Console.readLine();
        int bonusNumberint = Integer.parseInt(bonusNumberstr);

        ExceptionController.noIntegerValueException(bonusNumberstr);
        ExceptionController.noValidLottoNumberException(bonusNumberint);
        ExceptionController.overlapNumberException(winningNumberslist, bonusNumberint);

        bonusNumber = bonusNumberint;
    }
}