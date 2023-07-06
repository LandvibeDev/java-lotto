package lotto;

public class Rule {
	private int startNumber;
	private int endNumber;
	private int numberSize;

	public Rule(int startNumber, int endNumber, int numberSize) {
		this.startNumber = startNumber;
		this.endNumber = endNumber;
		this.numberSize = numberSize;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public int getEndNumber() {
		return endNumber;
	}

	public int getNumberSize() {
		return numberSize;
	}
}
