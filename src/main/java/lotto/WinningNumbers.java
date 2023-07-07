package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumberslist = new ArrayList<>();

    WinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        setWinningNumberslist(winningNumbers);
    }
    public void setWinningNumberslist(String winningNumbers){
        String correctString = "";

        for(int i=0; i<winningNumbers.length(); i++){
            char tmp = winningNumbers.charAt(i);
            if(tmp == ',') {
                int correctInteger = Integer.parseInt(correctString);

                ExceptionController.noValidLottoNumberException(correctInteger);
                ExceptionController.overlapNumberException(winningNumberslist, correctInteger);

                winningNumberslist.add(correctInteger);
                correctString = "";
                continue;
            }

            correctString += tmp;
            ExceptionController.noIntegerValueException(correctString);
        }
    }
}
