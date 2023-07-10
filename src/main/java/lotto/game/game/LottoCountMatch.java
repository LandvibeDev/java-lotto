package lotto.game.game;

import lotto.game.lotto.Lotto;
import lotto.game.result.LottoCount;

import java.util.ArrayList;
import java.util.List;

import static lotto.game.constant.WinningReward.*;

public class LottoCountMatch implements CountMatch {

    @Override
    public List<LottoCount> countMatchNumber(ArrayList<Integer> winningNumber, Integer bonusNumber, List<Lotto>lottoList) {
        List<LottoCount>lottoCountList = new ArrayList<>();
        for(Lotto lotto : lottoList){
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
            lottoCountList.add(lottoCount);
        }

        return lottoCountList;
    }

    @Override
    public int countMatchReward(List<LottoCount>lottoCountList){
        int reward = 0;
        for(LottoCount lottoCount : lottoCountList){
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
        }
        return reward;
    }
}
