package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameController {

    private void generateLotto(int money) {

    }

    private int readInputMoney() throws IllegalArgumentException {
        try {
            int money = Integer.parseInt(Console.readLine());
            return money;
        } catch (NumberFormatException numberFormatException) {
            // 에러 message 출력
            throw new IllegalArgumentException();
        }
    }

    private void checkValidMoney(int money) throws IllegalArgumentException {
        if (money % 1000 != 0) {
            // 에러 message 출력
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        int money = readInputMoney();
        checkValidMoney(money);

        generateLotto(money);
    }
}
