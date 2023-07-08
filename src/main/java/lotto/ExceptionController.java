package lotto;

import static lotto.Message.*;
import java.util.List;

public class ExceptionController {

    public static void noIntegerValueException(String Numbers){
        for(int i=0; i<Numbers.length(); i++){
            int isIntger = Numbers.charAt(i) - '0';
            if(isIntger<0 || isIntger>9){
                System.out.println(NOT_INTAGER_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    public static void noValidAmountException(String amount){
        if(Integer.parseInt(amount)%1000 != 0){
            System.out.println(NOT_THOUSAND_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void noValidLottoNumberException(int number){
        if(number<1 || number>45){
            System.out.println(NOT_OUTRANGE_NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void overlapNumberException(List<Integer> winningNumberList, int correctInteger){
        if(winningNumberList.contains(correctInteger)){
            System.out.println(OVERLAP_NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
