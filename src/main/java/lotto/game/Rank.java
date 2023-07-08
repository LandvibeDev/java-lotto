package lotto.game;

import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;

public class Rank {
    private final int count;
    private final boolean isBonus;
    Rank(Lotto lotto, WinningLotto winLotto){
        count = lotto.countMatch(winLotto);
        isBonus = lotto.isBonus(winLotto);
    }

    public void rankValue(int [] arr) {
        if(count == 3) {
            arr[5]++;
        }
        else if(count == 4) {
            arr[4]++;
        }
        else if(count == 5 && !isBonus) {
            arr[3]++;
        }
        else if(count == 5 && isBonus) {
            arr[2]++;
        }
        else if(count == 6) {
            arr[1]++;
        }
    }

}
