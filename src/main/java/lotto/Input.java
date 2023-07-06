package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;

public class Input {
    private final Print print;
    public static Input input;

    private Input() {
        print=Print.getInstance();
        input=new Input();
    }

    public static Input getInstance(){
        return input;
    }

    public int getPurchacePrice() {
        print.printGetPriceMessage();
        String input = Console.readLine();
        validatePrice(input);
        int result = Integer.parseInt(input);
        return result;
    }

    public List<Integer> getWiningNumber() {
        print.printWinningNumberMessage();
        String input = Console.readLine();
        String[] splitResult = input.split(",");
        List<Integer> result = new ArrayList<>();
        for (String oneSplitResult : splitResult) {
            int oneInput = Integer.parseInt(oneSplitResult);
            result.add(oneInput);
        }
        validateWinningNumber(result);
        print.printBonusNumberMessage();
        input = Console.readLine();
        result.add(Integer.parseInt(input));
        validateWinningNumber(result);
        return result;
    }

    private void validatePrice(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < MIN_BOUND_CHAR || input.charAt(i) > MAX_BOUND_CHAR) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

    private void validateWinningNumber(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) < MIN_BOUND || input.get(i) > MAX_BOUND) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

}
