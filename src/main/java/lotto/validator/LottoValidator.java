package lotto.validator;

import lotto.Constants;

import java.util.List;

public class LottoValidator implements Validator {

    @Override
    public void checkValidMultiples(int number) throws IllegalArgumentException {
        if (number % Constants.Lotto.PRICE != 0) {
            throw new IllegalArgumentException(Constants.Exception.ERROR_MESSAGE + Constants.Lotto.PRICE + Constants.Exception.VALID_MULTIPLES);
        }
    }

    @Override
    public void checkValidDuplicate(List<Integer> list, int number) throws IllegalArgumentException {
        if (list.contains(number)) {
            throw new IllegalArgumentException(Constants.Exception.ERROR_MESSAGE + Constants.Exception.NO_DUPLICATE);
        }
    }

    @Override
    public void checkValidRange(int number) {
        if (number < Constants.NumberRange.START || number > Constants.NumberRange.END) {
            throw new IllegalArgumentException(Constants.Exception.ERROR_MESSAGE + Constants.NumberRange.START + Constants.Exception.BETWEEN_SIGN + Constants.NumberRange.END + Constants.Exception.VALID_RANGE);
        }
    }

}

