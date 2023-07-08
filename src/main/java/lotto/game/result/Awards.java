package lotto.game.result;

public class Awards {
    private static Awards instance;

    // private 생성자로 외부에서의 인스턴스 생성을 막음
    private Awards() {
        awards[3]=5000;
        awards[4]=50000;
        awards[5]=1500000;
        awards[6]=2000000000;

        bonusAwards = 30000000;
    }

    // 유일한 인스턴스를 반환하는 정적 메서드
    public static Awards getInstance() {
        if (instance == null) {
            instance = new Awards();
        }
        return instance;
    }
    public int[] awards = new int[10];
    public int bonusAwards;

    public int[] getAwards() {
        return awards;
    }

    public int getBonusAwards() {
        return bonusAwards;
    }
}
