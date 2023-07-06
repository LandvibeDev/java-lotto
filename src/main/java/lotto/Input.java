package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public List<Integer> getInput(){
        System.out.println(Message.INPUT_NUMBER.getValue());
        String input=Console.readLine();
        String[] splitResult=input.split(",");
        List<Integer> result=new ArrayList<>();
        for(String a:splitResult){
            int oneInput=Integer.parseInt(a);
            result.add(oneInput);
        }
        validate(result);
        System.out.println(Message.INPUT_BONUS.getValue());
        input=Console.readLine();
        result.add(Integer.parseInt(input));
        validate(result);
        return result;
    }
    public void validate(List<Integer> input){
        for(int i=0;i<input.size();i++){
            if(input.get(i)<Constant.MIN_BOUND||input.get(i)>Constant.MAX_BOUND){
                throw new IllegalArgumentException();
            }
        }
    }
}
