package lotto.game.input;

import java.util.ArrayList;

public interface Input {

    ArrayList<Integer> getWinningNumbers();

    Integer getPurchaseMoney();

    Integer getBonusNumber();
}
