package lotto.game.game;

import lotto.game.lotto.Lotto;
import lotto.game.lotto.LottoCount;
import java.util.List;

import static lotto.game.constant.WinningReward.*;

public class LottoCountMatch implements CountMatch {
    @Override
    public LottoCount countMatchNumber(List<Integer> winningNumber, Integer bonusNumber, Lotto lotto) {
        int cnt = 0;
        int bonusCnt = 0;
        List<Integer>lottoNumber = lotto.getLottoNumber();
        for (Integer num : lottoNumber) {
            if (winningNumber.contains(num)) {
                cnt++;
            }
        }
        if(lottoNumber.contains(bonusNumber)){
            bonusCnt++;
        }
        LottoCount lottoCount = new LottoCount(cnt,bonusCnt);

        return lottoCount; // lottoCount 객체로 반환
    }
    @Override
    public int countMatchReward(LottoCount lottoCount){
        int reward = 0;
        int cnt = lottoCount.getCnt();
        int bonusCnt = lottoCount.getBonusCnt();

        if(cnt==3){
            reward += THREE_RIGHT.value();
        }
        if(cnt==4){
            reward += FOUR_RIGHT.value();
        }
        if(cnt==5){
            if(bonusCnt==1){
                reward += FIVE_AND_BONUS_RIGHT.value();
            }
            if(bonusCnt==0){
                reward += FIVE_RIGHT.value();
            }
        }
        if(cnt==6){
            reward += SIX_RIGHT.value();
        }
        return reward; // lottoCount 객체 reward 계산 후 return
    }
}
