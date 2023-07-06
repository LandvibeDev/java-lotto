package lotto;

public class Constant {
	public enum Rule {
		START_NUMBER(1),
		END_NUMBER(45),
		NUMBER_SIZE(6);

		private final int number;

		Rule(int number) {
			this.number = number;
		}

		public int get() {
			return number;
		}

	}
}
