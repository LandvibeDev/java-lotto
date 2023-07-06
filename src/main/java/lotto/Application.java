package lotto;


public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        Game game = new Game(RandomNumber.getInstance(), Input.getInstance(), Print.getInstance());
        try {
            game.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}