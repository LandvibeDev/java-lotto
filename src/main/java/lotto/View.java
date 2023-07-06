package lotto;

import static lotto.Constant.*;
import static lotto.Constant.Rule.*;

import java.text.DecimalFormat;
import java.util.List;

public class View {

	public void printRequestPurchaseMoney() {
		System.out.println(RequestMessage.REQUEST_INPUT_PURCHASE_MONEY);
	}

	public void printIssuedLottoList(int lottoCount, List<Lotto> lottoList) {
		System.out.println(ResponseMessage.LOTTO_COUNT_MESSAGE.getMessage(lottoCount));

		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}

	public void printRequestWinningLotto() {
		System.out.println(RequestMessage.REQUEST_INPUT_WINNING_LOTTO);
	}

	public void printRequestBonusNumber() {
		System.out.println(RequestMessage.REQUEST_INPUT_BONUS_NUMBER);
	}
	public void printWinningStatistics(Score score) {
		System.out.println(ResponseMessage.WINNING_STATISTICS_MESSAGE);

		System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_5th.get(),
			formatNumber(AMOUNT_OF_MONEY_5th.get()), score.getWinFifthPlace()));

		System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_4th.get(),
			formatNumber(AMOUNT_OF_MONEY_4th.get()), score.getWinFourthPlace()));

		System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_3rd.get(),
			formatNumber(AMOUNT_OF_MONEY_3rd.get()), score.getWinThirdPlace()));

		System.out.println(ResponseMessage.MATCH_MESSAGE_WITH_BONUS.getMatchMessage(MATCH_COUNT_2nd.get(),
			formatNumber(AMOUNT_OF_MONEY_2nd.get()), score.getWinSecondPlace()));

		System.out.println(ResponseMessage.MATCH_MESSAGE.getMatchMessage(MATCH_COUNT_1st.get(),
			formatNumber(AMOUNT_OF_MONEY_1st.get()), score.getWinFirstPlace()));
	}

	public String formatNumber(int amountOfMoney) {
		DecimalFormat decimalFormat = new DecimalFormat(Format.DECIMAL_PATTERN.get());
		String formattedNumber = decimalFormat.format(amountOfMoney);
		return formattedNumber;
	}

	public void printRateOfReturn(double rateOfReturn) {
		System.out.println(ResponseMessage.RATE_OF_RETURN_MESSAGE.getMessage(rateOfReturn));
	}

}
