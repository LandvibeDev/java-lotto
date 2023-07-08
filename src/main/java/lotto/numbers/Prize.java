package lotto.numbers;

public enum Prize {
    NONE(0),FIFTH(5000),FOURTH(50000),
    THIRD(1500000),SECOND(30000000),FIRST(2000000000);

    private final long value;

    private Prize(long value){
        this.value = value;
    }

    public long getValue() {
        return value;
    }

}
