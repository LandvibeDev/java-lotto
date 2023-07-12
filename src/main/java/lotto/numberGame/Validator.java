package lotto.numberGame;

public interface Validator {
	void handleException(boolean condition, String ErrorMessage);

	void printErrorMessage(IllegalArgumentException e);
}
