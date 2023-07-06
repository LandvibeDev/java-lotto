package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private final Print print;

    Input(){
        print=new Print();
    }

    public int getPurchacePrice(){
        print.printGetPrice();
        String input=Console.readLine();
        validatePrice(input);
        int result=Integer.parseInt(input);
        return result;
    }

    public List<Integer> getWiningNumber(){
        print.printWinningNumber();
        String input=Console.readLine();
        String[] splitResult=input.split(",");
        List<Integer> result=new ArrayList<>();
        for(String a:splitResult){
            int oneInput=Integer.parseInt(a);
            result.add(oneInput);
        }
        validateWinningNumber(result);
        print.printBonusNumber();
        input=Console.readLine();
        result.add(Integer.parseInt(input));
        validateWinningNumber(result);
        return result;
    }
    public void validatePrice(String input) {
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)<Constant.MIN_BOUND_CHAR||input.charAt(i)>Constant.MAX_BOUND_CHAR){
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }
    public void validateWinningNumber(List<Integer> input) {
        for(int i=0;i<input.size();i++){
            if(input.get(i)<Constant.MIN_BOUND||input.get(i)>Constant.MAX_BOUND){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

}
