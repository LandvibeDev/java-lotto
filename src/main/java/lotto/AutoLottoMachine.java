package lotto;

import static lotto.SettingValues.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class AutoLottoMachine implements Machine {
	Lotto autoLotto;
	List<Integer> numbers;
	@Override
	public void run() {
		numbers = Randoms.pickUniqueNumbersInRange(MIN_OF_RANGE.get(), MAX_OF_RANGE.get(), 6);
		numbers = numbers.stream()
			.sorted(Comparator.comparing(Integer::intValue))
			.collect(Collectors.toList());
		System.out.println(Arrays.toString(numbers.toArray()));
		autoLotto = new Lotto(numbers);
	}

	public Lotto getAutoLotto() {
		return autoLotto;
	}
}
