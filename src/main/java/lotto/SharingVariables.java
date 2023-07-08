package lotto;

import static lotto.Messages.*;
import static lotto.SettingValues.*;

import java.util.ArrayList;
import java.util.List;

public class SharingVariables {
	public static int[] numOfRanking = new int[6];
	public static final String NOTHING = "";
	public static final int[] rewards = {FAIL.get(), REWARD_OF_FIRST.get(), REWARD_OF_SECOND.get(),
		REWARD_OF_THIRD.get(), REWARD_OF_FOURTH.get(), REWARD_OF_FIFTH.get()};

	public static final String[] rewadsStr = {NOTHING, REWARD_OF_FIRST_STR.get(), REWARD_OF_SECOND_STR.get(),
		REWARD_OF_THIRD_STR.get(), REWARD_OF_FOURTH_STR.get(), REWARD_OF_FIFTH_STR.get()};
	public static final int[] rankings = {FIRST.get(), SECOND.get(), THIRD.get(), FOURTH.get(), FIFTH.get()};

	public static final int[] points = {ZERO.get(), POINT_OF_FIRST.get(), POINT_OF_SECOND.get(), POINT_OF_THIRD.get(),
		POINT_OF_FOURTH.get(), POINT_OF_FIFTH.get()};
	public static final String[] formats = {NOTHING, WINNING_MESSAGE_FORMAT_FIRST.get(),
		WINNING_MESSAGE_FORMAT_SECOND.get(), WINNING_MESSAGE_FORMAT_THIRD.get(), WINNING_MESSAGE_FORMAT_FOURTH.get(),
		WINNING_MESSAGE_FORMAT_FIFTH.get()};
	public static final double PERCENTAGE = 100.0;
	public static final long UNIT_OF_PURCHASE = 1000L;
	public static List<Lotto> userLottos = new ArrayList<>();
	public static final String DELIM = ",";

}
