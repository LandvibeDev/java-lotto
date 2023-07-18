package lotto;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        GameController game = new GameController(lottoManager);
        game.play();
    }
}