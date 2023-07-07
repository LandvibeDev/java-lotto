package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public String toString() {
        ArrayList<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        return numbers.toString();
    }

    /*public int calculateCorrectCount(List<Integer> correctNumberList){
        int correct=0;
        for(int i=0; i<correctNumberList.size(); i++){
            if(this.numbers.contains(correctNumberList.get(i))){
                correct++;
            }
        }
        return correct;
    }

    public boolean calculateBonusNumber(int bonusNumber){
        if(this.numbers.contains(bonusNumber)) return true;

        return false;
    }*/
}
