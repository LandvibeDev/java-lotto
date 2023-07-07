package lotto.input;

import java.util.List;

public interface Input {

    public int getPurchasePrice();

    public List<Integer> getWiningNumber();

    public void validatePrice(String input);

    public void validateWinningNumber(List<Integer> input);
}
