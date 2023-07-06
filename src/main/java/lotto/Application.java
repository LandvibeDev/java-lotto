package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        Input input=new Input();
        int purchacePrice=0;
        Game game=new Game(new RandomNumber(),new Input());
        try {
            game.run();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}