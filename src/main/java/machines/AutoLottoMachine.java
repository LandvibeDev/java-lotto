package machines;

import static config.SettingValues.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Printer;
import machines.interfaces.RandomNumsGenerator;

public class AutoLottoMachine implements RandomNumsGenerator {
	Lotto autoLotto;
	List<Integer> numbers;
	Printer printer;

	public AutoLottoMachine(){
		printer = new Printer();
	}

	@Override
	public void run() {
		numbers = sortIntegers(createRandomNums());
		printer.printList(numbers);
		autoLotto = new Lotto(numbers);
	}
	@Override
	public List<Integer> createRandomNums(){
		List<Integer> randomNums;
		randomNums = Randoms.pickUniqueNumbersInRange(MIN_OF_RANGE.get(), MAX_OF_RANGE.get(), NUMBER_SIZE.get());
		return randomNums;
	}
	public List<Integer> sortIntegers(List<Integer> numList){
		List<Integer> sortedNumList;
		sortedNumList = numList.stream()
			.sorted(Comparator.comparing(Integer::intValue))
			.collect(Collectors.toList());
		return sortedNumList;
	}

	public Lotto getAutoLotto() {
		return autoLotto;
	}
}
