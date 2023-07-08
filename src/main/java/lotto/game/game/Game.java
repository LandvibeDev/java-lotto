package lotto.game.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.game.input.Input;
import lotto.game.lotto.Lotto;
import lotto.game.print.Print;
import lotto.game.result.Awards;
import lotto.game.result.Count;
import lotto.game.result.Result;
import lotto.game.user.User;
import java.util.ArrayList;
import java.util.List;

import static lotto.game.game.MakeNumber.makeRandomLottoNumbers;

public class Game {
    Result result = new Result();
    User user = new User();
    Awards awards = new Awards();
    Count count = new Count();

    private Input input;
    private Print print;
    private List<Lotto>lottoList;

    public Game(Input input, Print print){
        this.input = input;
        this.print = print;
        this.lottoList = new ArrayList<>();
    }

    private void countMatchNumber(ArrayList<Integer> winningNumber, Integer bonusNumber, List<Integer> lottoNumber) {
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
    private void countMatchRefund(int cnt, int bonusCnt) {
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
    public void start() {
        // 1. 수량 입력받기
        Integer purchaseMoney = input.getPurchaseMoney();
        if(purchaseMoney==-1){
            return;
        }

        // 2. 구매수량 check
        int cycle = purchaseMoney / 1000;
        System.out.println(cycle + "개를 구매했습니다.");

        // 3. 수량만큼 로또 번호 생성
        makeRandomLottoNumbers(cycle,lottoList);

        // 4. 생성된 로또번호 보여주기
        print.printNumberList(lottoList);

        // 5. 당첨 번호, 보너스 번호 입력받기
        ArrayList<Integer> winningNumber = input.getWinningNumber();
        Integer bonusNumber = input.getBonusNumber();

        // 6. 결과 집계
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

        // 7. 결과 출력
        print.printResultStart();
        print.printResult(awards,result);
        print.printRateOfReturn(purchaseMoney,user);
    }




}