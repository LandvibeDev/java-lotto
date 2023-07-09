package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinnerLottoData {
    public Lotto number;
    public int bonusNumber;

    public void parseWinnerNumber(String input) {
        String[] stringArray = input.split(",");
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringArray) {
            int num = Integer.parseInt(str);
            integerList.add(num);
        }
        this.number = new Lotto(integerList);
    }
}