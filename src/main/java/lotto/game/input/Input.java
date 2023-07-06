package lotto.game.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.game.exception.Check;

import java.util.ArrayList;

public class Input {

    public static Integer getPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요");
        String str = Console.readLine();

        try {
            Check.purchaseCheck(str);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }

        int purchase = Integer.parseInt(str);
        System.out.println();
        return purchase;
    }

    public static ArrayList<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String str = Console.readLine();
        String[] split = str.split(",");

        ArrayList<Integer>arrayList = new ArrayList<>();
        for(int i = 0; i<split.length; i++){
            arrayList.add(Integer.valueOf(split[i]));
        }
        System.out.println();
        return arrayList;
    }

    public static Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.valueOf(Console.readLine());
        System.out.println();
        return bonusNumber;
    }
}
