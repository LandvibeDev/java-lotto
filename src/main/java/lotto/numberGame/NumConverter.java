package lotto.numberGame;

import java.util.StringTokenizer;

public class NumConverter {

	private static final String FRAC_POINT = ".";
	private static String retStr;

	public static String doubleToString(Double value, int cutSize) {
		retStr = String.format("%." + cutSize + "f", value);
		StringTokenizer splittedValue = new StringTokenizer(retStr, FRAC_POINT);
		String intPart = splittedValue.nextToken();
		String fracPart = splittedValue.nextToken();
		intPart = intToString(Integer.parseInt(intPart));
		retStr = intPart + FRAC_POINT + fracPart;
		return retStr;
	}

	public static String intToString(Integer value) {
		retStr = value.toString();
		retStr = retStr.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		return retStr;
	}
}
