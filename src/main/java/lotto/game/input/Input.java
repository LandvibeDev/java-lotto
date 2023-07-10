package lotto.game.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Input {

    public Integer getPurchaseMoney() {
        System.out.println(InputMessage.INPUT_PURCHASE_PRICE.getString());
        String str = Console.readLine();

        try {
            CheckInput.purchaseCheck(str);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }

        int purchase = Integer.parseInt(str);
        System.out.println();
        return purchase;
    }

    public ArrayList<Integer> getWinningNumber() {
        System.out.println(InputMessage.INPUT_NUMBERS.getString());
        String str = Console.readLine();
        String[] split = str.split(",");

        ArrayList<Integer>arrayList = new ArrayList<>();
        for(int i = 0; i<split.length; i++){
            arrayList.add(Integer.valueOf(split[i]));
        }
        System.out.println();
        return arrayList;
    }

    public Integer getBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getString());
        Integer bonusNumber = Integer.valueOf(Console.readLine());
        System.out.println();
        return bonusNumber;
    }
}
