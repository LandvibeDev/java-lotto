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

    public RandomNumber getRandomNumber() {
        return RandomNumberImpl.getInstance();
    }

    public Input getInput() {
        return InputImpl.getInstance();
    }

    public Print getPrint() {
        return PrintImpl.getInstance();
    }


    public Game getGame() {
        return new GameImpl(getRandomNumber(), getInput(), getPrint());
    }
}
