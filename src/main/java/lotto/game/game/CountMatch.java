package lotto.game.game;

import lotto.game.result.Awards;
import lotto.game.result.Count;
import lotto.game.result.Result;
import lotto.game.user.User;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class CountMatch {
    // 싱글톤으로 해결해보자
    Count count = Count.getInstance();
    Result result = Result.getInstance();
    Awards awards = Awards.getInstance();
    User user = User.getInstance();

    public void countMatchNumber(ArrayList<Integer> winningNumber, Integer bonusNumber, List<Integer> lottoNumber) {
        for (Integer num : lottoNumber) {
            if (winningNumber.contains(num)) {
                count.countUp();
            }
        }
        // 보너스 체크
        if(lottoNumber.contains(bonusNumber)){
            count.countUpBonus();
        }
    }
    public void countMatchRefund(int cnt, int bonusCnt) {
        result.upCountResult(cnt);
        user.updateRefund(awards.getAwards()[cnt]);

        if(cnt ==5){
            if(bonusCnt ==1){
                result.upCountBonusResult();
                user.updateRefund(awards.getBonusAwards());
            }
            if(bonusCnt !=1){
                result.downCountResult(cnt);
                user.updateRefund(-awards.getAwards()[cnt]);
            }
        }
    }
}
