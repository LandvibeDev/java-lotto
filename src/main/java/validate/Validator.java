package validate;

public interface Validator {
	void handleException(boolean condition, String ErrorMessage);
	void printErrorMessage(IllegalArgumentException e);
}
