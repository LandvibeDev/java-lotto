package lotto.game.constant;

public enum NumberRange {
    RESULT_START(3),
    RESULT_END(6),
    RANDOM_START(1),
    RANDOM_END(45),
    RANDOM_COUNT(6);

    public int value() {
        return value;
    }

    private final int value;

    NumberRange(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
