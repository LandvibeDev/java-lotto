package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    /*
    int firstPlace;
    int secondPlace;
    int thirdPlace;
    int fourthPlace;
    int fifthPlace;

     */
    int [] place;

    private final RandomNumber randomNumber;
    private final Input input;
    private int amount;
    private int price;
    Print print;


    Game(RandomNumber randomNumber,Input input){
        this.randomNumber=randomNumber;
        this.input=input;
        /*
        firstPlace=0;
        secondPlace=0;
        thirdPlace=0;
        fourthPlace=0;
        fifthPlace=0;
         */
        place=new int[5];
        this.print=new Print();
    }

    public void run(){
        List<int[]> winCounts=new ArrayList<>();
        List<List<Integer>> list=new ArrayList<>();
        price=input.getPurchacePrice();
        amount =price/1000;
        print.printAmount(amount);
        for(int i = 0; i< amount; i++){
            List<Integer> randomNumbers=randomNumber.getRandomNumber();
            list.add(randomNumbers);
            //Compare compare=new Compare(input.getInput(),randomNumbers);
            //winCounts.add(compare.winCount(compare.compare()));
        }
        List<Integer> a=input.getWiningNumber();
        for(int i = 0; i< amount; i++){
            Compare compare=new Compare(a,list.get(i));
            winCounts.add(compare.winCount(compare.compare()));
        }
        for(int i=0;i<winCounts.size();i++){
            if(winCounts.get(i)[0]==6){
                //firstPlace++;
                place[0]++;
                continue;
            }
            if(winCounts.get(i)[0]==5){
                if(winCounts.get(i)[1]==1){
                  //  secondPlace++;
                    place[1]++;
                    continue;
                }
                //thirdPlace++;
                place[2]++;
                continue;
            }
            if(winCounts.get(i)[0]==4){
                //fourthPlace++;
                place[3]++;
                continue;
            }
            if(winCounts.get(i)[0]==3){
                //fifthPlace++;
                place[4]++;
            }
        }
        print.printResult(place,price);
    }

}
