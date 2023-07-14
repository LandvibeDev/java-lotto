package lotto.config;


import lotto.game.Game;
import lotto.game.GameImpl;
import lotto.input.Input;
import lotto.input.InputImpl;
import lotto.print.Print;
import lotto.print.PrintImpl;
import lotto.randomNumber.RandomNumber;
import lotto.randomNumber.RandomNumberImpl;

public class LottoConfig {

    public RandomNumber randomNumber() {
        return RandomNumberImpl.getInstance();
    }

    public Input input() {
        return InputImpl.getInstance();
    }

    public Print print() {
        return PrintImpl.getInstance();
    }


    public Game game() {
        return new GameImpl(randomNumber(), input(), print());
    }
}
