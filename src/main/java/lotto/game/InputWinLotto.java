package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import lotto.checkexception.CheckException;
import lotto.checkexception.CheckExceptionImpl;

import java.util.ArrayList;
import java.util.List;

public class InputWinLotto {
    private final WinningLotto winningLotto;
    private final Lotto lotto;

    public InputWinLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine().toString();
        String[] words = input.split(",");
        List<Integer> list = new ArrayList<>();
        for (String word : words) {
            CheckException checkException = new CheckExceptionImpl();
            int check = Integer.parseInt(word);
            checkException.checkException(check);
            list.add(check);
        }

        lotto = new Lotto(list);
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonus = Console.readLine();
        int bonus = Integer.parseInt(inputBonus);
        winningLotto = new WinningLotto(lotto,bonus);
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
