package lotto;

public class Application {
    public static void main(String[] args) {
        NumberGame chosenNumberGame = new LottoGame();
        GameManager gameManager = new GameManager(chosenNumberGame);
        gameManager.playGame();
    }
}