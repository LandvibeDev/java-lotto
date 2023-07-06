package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Message.INPUT_PRICE.getValue());
        RandomNumber randomNumber=new RandomNumber();
        Print print=new Print();
        Input input=new Input();
        int price= Integer.parseInt(Console.readLine());
        print.printAmount(price/1000);
        Game game=new Game(randomNumber,input,price);
        game.run();
    }
}