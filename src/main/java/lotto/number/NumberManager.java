package lotto.number;

import java.util.List;

public interface NumberManager {

    int generate(String command);

    int generateBonus(String str, List<Integer> list) throws IllegalArgumentException;

    List<Lotto> generateLists(int start, int end, int count, int listSize);

    List<Integer> generateList(String[] strings) throws IllegalArgumentException;

    List<Integer> calculate(List<Lotto> lottoList, Lotto winningLotteryNumber, int bonus);

}
