package lotto.lotto;

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

    // TODO: 추가 기능 구현
    public int countMatch(WinningLotto lotto){
        int count = 0;
        for (Integer number : this.numbers) {
            if(lotto.getLotto().numbers.contains(number)) count++;
        }
        return count;
    }

    public boolean isBonus(WinningLotto lotto){
        return this.numbers.contains(lotto.getBonus());
    }

    public void printValues(){
        String str = "[";
        for (Integer number : numbers) {
            str += number.toString();
            str += ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        System.out.println(str);
    }
}