package lotto.game.game;

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
    Result result = Result.getInstance();
    User user = User.getInstance();
    Awards awards = Awards.getInstance();
    Count count = Count.getInstance();

    private final Input input;
    private final Print print;
    private final CountMatch countMatch;
    private List<Lotto>lottoList;

    public Game(Input input, Print print, CountMatch countMatch){
        this.input = input;
        this.print = print;
        this.countMatch = countMatch;
        this.lottoList = new ArrayList<>();
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
            countMatch.countMatchNumber(winningNumber, bonusNumber, lottoNumber);
            // user refund update
            countMatch.countMatchRefund(count.getCnt(), count.getBonusCnt());
        }

        // 7. 결과 출력
        print.printResultStart();
        print.printResult(awards,result);
        print.printRateOfReturn(purchaseMoney,user);
    }




}
