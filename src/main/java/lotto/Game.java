package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
    int firstPlace;
    int secondPlace;
    int thirdPlace;
    int fourthPlace;
    int fifthPlace;

    private final RandomNumber randomNumber;
    private final Input input;
    private int count;
    private int price;


    Game(RandomNumber randomNumber,Input input,int price){
        this.randomNumber=randomNumber;
        this.input=input;
        this.price=price;
        count=price/1000;
        firstPlace=0;
        secondPlace=0;
        thirdPlace=0;
        fourthPlace=0;
        fifthPlace=0;
    }

    public void run(){
        List<int[]> winCounts=new ArrayList<>();
        List<Set<Integer>> list=new ArrayList<>();
        for(int i=0;i<count;i++){
            Set<Integer> randomNumbers=randomNumber.getRandomNumber();
            System.out.println(randomNumbers);
            list.add(randomNumbers);
            //Compare compare=new Compare(input.getInput(),randomNumbers);
            //winCounts.add(compare.winCount(compare.compare()));
        }
        List<Integer> a=input.getInput();
        for(int i=0;i<count;i++){
            Compare compare=new Compare(a,list.get(i));
            winCounts.add(compare.winCount(compare.compare()));
        }


        for(int i=0;i<winCounts.size();i++){
            if(winCounts.get(i)[0]==6){
                firstPlace++;
                continue;
            }
            if(winCounts.get(i)[0]==5){
                if(winCounts.get(i)[1]==1){
                    secondPlace++;
                    continue;
                }
                thirdPlace++;
                continue;
            }
            if(winCounts.get(i)[0]==4){
                fourthPlace++;
                continue;
            }
            if(winCounts.get(i)[0]==3){
                fifthPlace++;
            }
        }
        printResult();
    }
    public void printResult(){
        int result=0;
        Print print=new Print();
        result+=print.printThree(fifthPlace);
        result+=print.printFour(fourthPlace);
        result+=print.printFive(thirdPlace);
        result+=print.printFiveBonus(secondPlace);
        result+=print.printSix(firstPlace);
        print.printResult(result,price);
    }

}
