package lotto.number;

import lotto.Constants;

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
        if (numbers.size() != Constants.NumberRange.COUNT) {
            throw new IllegalArgumentException(Constants.Exception.ERROR_MESSAGE + Constants.Exception.NO_DUPLICATE);
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