package lotto.number;

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
            throw new IllegalArgumentException("[ERROR]" + " 중복되지 않게 수를 입력하세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> deepCopy(List<Integer> numbers) {
        List<Integer> copy = new ArrayList<>();
        copy.addAll(numbers);
        return copy;
    }

    @Override
    public String toString() {
        List<Integer> deepCopy = deepCopy(numbers); // immutable
        Collections.sort(deepCopy);
        return deepCopy.toString();
    }

}