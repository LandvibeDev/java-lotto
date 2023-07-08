package lotto;

import lotto.game.game.CountMatch;
import lotto.game.game.Game;
import lotto.game.input.Input;
import lotto.game.print.Print;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Print print = new Print();
        CountMatch countMatch = new CountMatch();

        Game game = new Game(input,print,countMatch);
        game.start();
    }
}