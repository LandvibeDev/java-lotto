package machines.interfaces;

import java.util.List;

public interface NumberCompareMachine extends Machine {
	void inputWinningNums();

	int compare(List<Integer> userNums);
}
