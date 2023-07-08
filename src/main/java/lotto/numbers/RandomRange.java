package lotto.numbers;

public enum RandomRange {
    MIN_VALUE(1),MAX_VALUE(45),SIZE(6);

    private final int value;

    RandomRange(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
