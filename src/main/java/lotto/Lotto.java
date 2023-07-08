package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public MatchedNumbers match(WinningNumbers winningNumbers) {
        MatchedNumbers matchedNumbers = new MatchedNumbers();
        for (Integer number : numbers) {
            if(winningNumbers.mainNumbers.contains(number)) {
                matchedNumbers.mainNumberMatching++;
            }
            if(winningNumbers.bonusNumber == number) {
                matchedNumbers.bonusNumberMatching++;
            }
        }
        return matchedNumbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}