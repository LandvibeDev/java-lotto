package lotto.validator;

import java.util.List;

public interface Validator {

    void checkValidMultiples(int number) throws IllegalArgumentException;

    void checkValidDuplicate(List<Integer> list, int number) throws IllegalArgumentException;

    void checkValidRange(int number);
}
