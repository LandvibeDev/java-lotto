package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Compare {

    private final List<Integer> input;
    private final Set<Integer> randomNumber;

    Compare(List<Integer> input, Set<Integer> randomNumber) {
        this.input = input;
        this.randomNumber = randomNumber;
    }

    public List<Integer> compare() {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<Constant.DIGITS;i++){
            if(randomNumber.contains(input.get(i))){
                result.add(1);
            }
        }
        if(randomNumber.contains(input.get(Constant.DIGITS))){
            result.add(2);
        }
        return result;
    }
    public int [] winCount(List<Integer> list){
        int [] result=new int[2];
        result[0]=Collections.frequency(list,1);
        result[1]=Collections.frequency(list,2);
        return result;
    }
}
