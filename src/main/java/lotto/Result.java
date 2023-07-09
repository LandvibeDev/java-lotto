package lotto;

public enum Result {
    FIRST(2000000000, 1), SECOND(30000000, 2), THIRD(1500000, 3), FOURTH(50000, 4), FIFTH(5000, 5), NONE(0, 6);

    public int prize;
    public int order;

    Result(int prize, int order) {
        this.prize = prize;
        this.order = order;
    }
}
