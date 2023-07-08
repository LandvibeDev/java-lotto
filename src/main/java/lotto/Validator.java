package lotto;

public class Validator {
	public boolean isNotInteger(String inStr) {
		for (char c : inStr.toCharArray()) {
			if (c < '0' || c > '9')
				return true;
		}
		return false;
	}
}
