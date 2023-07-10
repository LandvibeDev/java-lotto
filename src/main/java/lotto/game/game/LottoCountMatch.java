package lotto.game.game;

import lotto.game.lotto.Lotto;
import lotto.game.result.Awards;
import lotto.game.result.Count;
import lotto.game.result.Result;
import lotto.game.user.User;

import java.util.ArrayList;
import java.util.List;

public class LottoCountMatch implements CountMatch {
    // 싱글톤으로 해결해보자
    Count count = Count.getInstance();
    Result result = Result.getInstance();
    Awards awards = Awards.getInstance();
    User user = User.getInstance();

    @Override
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
    @Override
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

    @Override
    public void countLottoResult(ArrayList<Integer> winningNumber, Integer bonusNumber, List<Lotto>lottoList) {
        for(Lotto lotto : lottoList){
            // 카운팅은 매번 초기화 되어야한다.
            count.reset();
            // 저장된 list 하나씩 빼오기
            List<Integer> lottoNumber = lotto.getLottoNumber();
            // 번호 일치여부 판별
            countMatchNumber(winningNumber, bonusNumber, lottoNumber);
            // user refund update
            countMatchRefund(count.getCnt(), count.getBonusCnt());
        }
    }
}
