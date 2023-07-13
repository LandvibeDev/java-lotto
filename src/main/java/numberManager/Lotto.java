package numberManager;

import static validator.ExceptionController.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;

        try {
            noValidDigitExecption(numbers);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

    }

    @Override
    public String toString() {
        ArrayList<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        return numbers.toString();
    }

    public int calculateCorrectCount(List<Integer> winningNumberList){
        int correct=0;
        for(int i=0; i<winningNumberList.size(); i++){
            if(this.numbers.contains(winningNumberList.get(i))){
                correct++;
            }
        }
        return correct;
    }

    public boolean calculateBonusNumber(int bonusNumber){
        if(this.numbers.contains(bonusNumber)) return true;

        return false;
    }
}
