package lotto;

import static lotto.Message.*;

public class Print {
    public int printSix(int value){
        System.out.println(EQUAL_SIX.getValue()+value+"개");
        return 2000000000*value;
    }
    public int printFive(int value){
        System.out.println(EQUAL_FIVE.getValue()+value+"개");
        return 1500000*value;
    }
    public int printFiveBonus(int value){
        System.out.println(EQUAL_FIVE_BONUS.getValue()+value+"개");
        return 30000000*value;
    }
    public int printFour(int value){
        System.out.println(EQUAL_FOUR.getValue()+value+"개");
        return 50000*value;
    }
    public int printThree(int value){
        System.out.println(EQUAL_THREE.getValue()+value+"개");
        return 5000*value;
    }
    public void printProfitResult(int result, int price){
        System.out.println("총 수익률은 "+100*((double)result/price)+"%입니다.");
    }
    public void printAmount(int amount){
        System.out.println(+amount+ OUTPUT_AMOUNT.getValue());
    }
    public void printGetPrice(){
        System.out.println(INPUT_PRICE.getValue());
    }
    public void printWinningNumber(){
        System.out.println(INPUT_NUMBER.getValue());
    }
    public void printBonusNumber(){
        System.out.println(INPUT_BONUS.getValue());
    }
    public void printResult(int[] place,int price){
        int result=0;
        result+=printThree(place[4]);
        result+=printFour(place[3]);
        result+=printFive(place[2]);
        result+=printFiveBonus(place[1]);
        result+=printSix(place[0]);
        printProfitResult(result,price);
    }

}
