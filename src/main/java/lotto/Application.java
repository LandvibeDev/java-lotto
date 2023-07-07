package lotto;


import lotto.game.Game;
import lotto.game.GameImpl;
import lotto.input.InputImpl;
import lotto.print.PrintImpl;
import lotto.randomNumber.RandomNumberImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new GameImpl(RandomNumberImpl.getInstance(), InputImpl.getInstance(), PrintImpl.getInstance());
        try {
            game.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}