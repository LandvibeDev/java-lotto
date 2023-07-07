package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;
import static lotto.Constant.MAX_BOUND;

public interface Input {

    public int getPurchasePrice();

    public List<Integer> getWiningNumber();

    public void validatePrice(String input);

    public void validateWinningNumber(List<Integer> input);
}
