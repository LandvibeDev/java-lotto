package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class RandomNumber {
    /*
    public Set<Integer> getRandomNumber(){
        Set<Integer> result=new TreeSet<>();
        while(result.size()< Constant.DIGITS){
            int randomNumber=Randoms.pickNumberInRange(Constant.MIN_BOUND,Constant.MAX_BOUND);
            result.add(randomNumber);
        }
        System.out.println(result);
        return result;
    }

     */
    public List<Integer> getRandomNumber(){
        List<Integer> randomNumber= new ArrayList<>(Randoms.pickUniqueNumbersInRange(Constant.MIN_BOUND,Constant.MAX_BOUND,Constant.DIGITS));
        Collections.sort(randomNumber);
        System.out.println(randomNumber);
        return randomNumber;
    }
}
