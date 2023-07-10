package lotto.game.constant;

public enum WinningReward {
    SIX_RIGHT(2000000000),
    FIVE_AND_BONUS_RIGHT(30000000),
    FIVE_RIGHT(1500000),
    FOUR_RIGHT(50000),
    THREE_RIGHT(5000);

    public int value() {
        return value;
    }

    private final int value;

    WinningReward(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
