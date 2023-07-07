package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class AutoLottoMachine implements Machine {
	Lotto autoLotto;
	List<Integer> numbers;
	public AutoLottoMachine(){
		numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}
	@Override
	public void run() {
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
