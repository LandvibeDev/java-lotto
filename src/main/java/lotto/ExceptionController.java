package lotto;

public class ExceptionController {
    public void noIntegerValueExeption(String Numbers){
        for(int i=0; i<Numbers.length(); i++){
            int isIntger = Numbers.charAt(i) - '0';
            if(isIntger<0 || isIntger>9){
                System.out.println("[ERROR] : 정수값이 아닙니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void noValidAmount(String amount){
        if(Integer.parseInt(amount)%1000 != 0){
            System.out.println("[ERROR] : 천원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
