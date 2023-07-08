package lotto.number;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;
import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberManager implements NumberManager {

    private final Validator validator;

    public LottoNumberManager(Validator validator) {
        this.validator = validator;
    }

    private int convertToInt(String command) throws IllegalArgumentException {
        int money;
        try {
            money = Integer.parseInt(command);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(Constants.Exception.ERROR_MESSAGE + Constants.Exception.VALID_INTEGER);
        }
        return money;
    }

    @Override
    public int generate(String str) throws IllegalArgumentException {
        int integer;
        try {
            integer = convertToInt(str);
            validator.checkValidMultiples(integer);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return integer;
    }

    @Override
    public int generateBonus(String str, List<Integer> list) throws IllegalArgumentException {
        int integer;
        try {
            integer = convertToInt(str);
            validator.checkValidRange(integer);
            validator.checkValidDuplicate(list, integer);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return integer;
    }

    private Lotto generateOne(int start, int end, int count) {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(start, end, count);
        return new Lotto(list);
    }

    @Override
    public List<Lotto> generateLists(int start, int end, int count, int listSize) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(generateOne(start, end, count));
        }
        return list;
    }

    @Override
    public List<Integer> generateList(String[] strings) throws IllegalArgumentException {
        List<Integer> list = new ArrayList<>();

        for (String str : strings) {
            int integer;
            try {
                integer = convertToInt(str);
                validator.checkValidRange(integer);
                validator.checkValidDuplicate(list, integer);
                list.add(integer);
            } catch (IllegalArgumentException illegalArgumentException) {
                throw illegalArgumentException;
            }
        }
        return list;
    }

    private int countMatch(Lotto winningNumbers, Lotto lotto) {
        int count = 0;
        for (Integer num : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(num))
                count++;
        }
        return count;
    }

    private void updateMatchCountList(Lotto lotto, ArrayList<Integer> matchCountList, int bonus, int count) {
        if (count < Constants.Winning.FIFTH)
            return;

        if (count == Constants.Winning.FIFTH && lotto.getNumbers().contains(bonus)) {
            matchCountList.set(Constants.Winning.SECOND, matchCountList.get(Constants.Winning.SECOND) + 1);
            return;
        }

        matchCountList.set(count, matchCountList.get(count) + 1);
    }

    @Override
    public List<Integer> calculate(List<Lotto> lottoList, Lotto winningLotteryNumber, int bonus) {
        ArrayList<Integer> matchCountList = new ArrayList<>(Collections.nCopies(Constants.NumberRange.COUNT + 1, 0));

        for (Lotto lotto : lottoList) {
            int count = countMatch(winningLotteryNumber, lotto);
            updateMatchCountList(lotto, matchCountList, bonus, count);
        }
        return matchCountList;
    }

}
