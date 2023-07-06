package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Set;
import java.util.TreeSet;


public class RandomNumber {
    public Set<Integer> getRandomNumber(){
        Set<Integer> result=new TreeSet<>();
        while(result.size()< Constant.DIGITS){
            int randomNumber=Randoms.pickNumberInRange(Constant.MIN_BOUND,Constant.MAX_BOUND);
            result.add(randomNumber);

        }
        return result;
    }
}
