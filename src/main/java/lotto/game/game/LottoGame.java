package lotto.game.game;

import lotto.game.input.Input;
import lotto.game.lotto.Lotto;
import lotto.game.print.Print;
import lotto.game.result.LottoCount;

import java.util.ArrayList;
import java.util.List;

import static lotto.game.game.MakeNumber.makeRandomLottoNumbers;

public class LottoGame implements Game{

    private final Input input;
    private final Print print;
    private final CountMatch countMatch;
    private final List<Lotto>lottoList;

    public LottoGame(Input input, Print print, CountMatch countMatch){
        this.input = input;
        this.print = print;
        this.countMatch = countMatch;
        this.lottoList = new ArrayList<>();
    }

    @Override
    public void start() {
        // 1. 수량 입력받기
        Integer purchaseMoney = input.getPurchaseMoney();
        if(purchaseMoney==-1){
            // error 발생
            return;
        }

        // 2. 구매수량 check
        int cycle = purchaseMoney / 1000;
        print.printPurchaseCount(cycle);

        // 3. 수량만큼 로또 번호 생성
        makeRandomLottoNumbers(cycle,lottoList);

        // 4. 생성된 로또번호 보여주기
        print.printNumberList(lottoList);

        // 5. 당첨 번호, 보너스 번호 입력받기
        ArrayList<Integer> winningNumber = input.getWinningNumbers();
        Integer bonusNumber = input.getBonusNumber();

        // 6. 결과 집계
        List<LottoCount> lottoCountList = countMatch.countMatchNumber(winningNumber, bonusNumber, lottoList);
        int reward = countMatch.countMatchReward(lottoCountList);

        // 7. 결과 출력
        print.printResultStart();
        print.printResult(lottoCountList);
        print.printRateOfReturn(purchaseMoney,reward);
    }




}
