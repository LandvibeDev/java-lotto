package lotto.checkexception;

import lotto.numbers.RandomRange;

public class CheckExceptionImpl implements CheckException{
    public void checkException(int check) {
        if (check > RandomRange.MAX_VALUE.getValue() || check < RandomRange.MIN_VALUE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
