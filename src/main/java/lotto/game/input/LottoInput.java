package lotto.game.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

import static lotto.game.constant.InputMessage.*;

public class LottoInput implements Input {

    @Override
    public Integer getPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_PRICE.getString());
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

    @Override
    public ArrayList<Integer> getWinningNumbers() {
        System.out.println(INPUT_NUMBERS.getString());
        String str = Console.readLine();
        String[] split = str.split(",");

        ArrayList<Integer>arrayList = new ArrayList<>();
        for (String s : split) {
            arrayList.add(Integer.valueOf(s));
        }
        System.out.println();
        return arrayList;
    }

    @Override
    public Integer getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getString());
        Integer bonusNumber = Integer.valueOf(Console.readLine());
        System.out.println();
        return bonusNumber;
    }
}
