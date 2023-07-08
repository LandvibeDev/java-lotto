package lotto.game.input;

public class CheckInput {

    static void purchaseCheck(String str) {

        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 올바르지 않습니다");
        }

        if (number % 1000 != 0 || number < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 수만 입력하세요");
        }
    }

}
