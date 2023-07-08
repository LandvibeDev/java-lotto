package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.Lotto;
import lotto.game.money.BuyMoney;
import lotto.game.money.EarnMoney;
import lotto.numbers.RandomRange;

import java.util.ArrayList;
import java.util.List;

public class LottoGame implements Game{

    private int [] prize = {0,0,0,0,0,0};
    public LottoGame(){

    }
    @Override
    public void play() {
        try {
            BuyMoney buyMoney = new BuyMoney();
            int count = buyMoney.getBuyCount();
            List<Lotto> lottoList = new ArrayList<>();
            makeNewLottoList(count, lottoList);
            for (Lotto lotto : lottoList) {
                lotto.printValues();
            }
            InputWinLotto inputWinLotto = new InputWinLotto();

            for (Lotto lotto : lottoList) {
                Rank rank = new Rank(lotto, inputWinLotto.getWinningLotto());
                rank.rankValue(prize);
            }
            EarnMoney earnMoney = new EarnMoney();
            earnMoney.addMoney(prize);


            PrintCorrectCount printCorrectCount = new PrintCorrectCount(prize);
            printCorrectCount.print(calculateRate(buyMoney, earnMoney));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    private static double calculateRate(BuyMoney buyMoney, EarnMoney earnMoney) {
        double result = (double)earnMoney.getEarnMoney() / (double)buyMoney.getBuyMoney() * 100;
        return Double.parseDouble(String.format("%.1f",result));
    }

    private static void makeNewLottoList(int count, List<Lotto> lottoList) {
        for(int i = 0; i < count; i++){
            List<Integer> ranNum = Randoms.pickUniqueNumbersInRange(RandomRange.MIN_VALUE.getValue(), RandomRange.MAX_VALUE.getValue(),RandomRange.SIZE.getValue());
            lottoList.add(new Lotto(ranNum));
        }
    }
}
