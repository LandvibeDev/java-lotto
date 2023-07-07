package lotto;

import java.util.List;

public class ExceptionController {

    public static void noIntegerValueException(String Numbers){
        for(int i=0; i<Numbers.length(); i++){
            int isIntger = Numbers.charAt(i) - '0';
            if(isIntger<0 || isIntger>9){
                System.out.println("[ERROR] : 정수값이 아닙니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void noValidAmountException(String amount){
        if(Integer.parseInt(amount)%1000 != 0){
            System.out.println("[ERROR] : 천원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void noValidLottoNumberException(int number){
        if(number<1 || number>45){
            System.out.println("[ERROR] : 로또 번호의 범위를 초과하였습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void overlapNumberException(List<Integer> winningNumberList, int correctInteger){
        if(winningNumberList.contains(correctInteger)){
            System.out.println("[ERROR] : 중복되는 번호입니다.");
            throw new IllegalArgumentException();
        }
    }
}
