package lotto;

public class GameManager {

    private NumberGame numberGame;

    public GameManager(NumberGame chosenGame) {
        this.numberGame = chosenGame;
    }

    public void playGame() {
        numberGame.play();
    }
}
