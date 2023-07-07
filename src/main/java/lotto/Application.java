package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");

        Integer coin = Integer.parseInt(Console.readLine())/1000;
        Lotto[] lottos = new Lotto[coin];

        System.out.println(coin + "개를 구매했습니다.");
        for(int i=0; i<coin; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos[i] = new Lotto(numbers);
            System.out.println(lottos[i].toString());
        }


    }
}

