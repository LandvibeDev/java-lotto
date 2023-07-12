package lotto;


import lotto.config.LottoConfig;
import lotto.game.Game;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoConfig lottoConfig=new LottoConfig();
        Game game = lottoConfig.getGame();
        try {
            game.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}