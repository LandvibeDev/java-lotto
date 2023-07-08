package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import lotto.checkexception.CheckCharException;
import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import lotto.checkexception.CheckException;
import lotto.checkexception.CheckExceptionImpl;
import lotto.numbers.RandomRange;

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
        CheckException checkException = new CheckExceptionImpl();
        CheckCharException checkCharException = new CheckCharException();
        for (String word : words) {
            checkCharException.checkCharException(word);
            int check = Integer.parseInt(word);
            checkException.checkException(check);
            if(list.contains(check)) throw new IllegalArgumentException("[ERROR]로또 번호는 중복될 수 없습니다.");
            list.add(check);
        }
        if(list.size() != RandomRange.SIZE.getValue()) throw new IllegalArgumentException("[ERROR]숫자 6개를 입력해주세요.");

        lotto = new Lotto(list);
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonus = Console.readLine();
        checkCharException.checkCharException(inputBonus);
        int bonus = Integer.parseInt(inputBonus);
        checkException.checkException(bonus);
        if(list.contains(bonus)) throw new IllegalArgumentException("[ERROR]로또 번호는 중복될 수 없습니다.");
        winningLotto = new WinningLotto(lotto,bonus);
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
