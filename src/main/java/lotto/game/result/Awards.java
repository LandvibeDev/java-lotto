package lotto.game.result;

public class Awards {
    public int[] awards = new int[10];
    public int bonusAwards;

    public Awards(){
        awards[3]=5000;
        awards[4]=50000;
        awards[5]=1500000;
        awards[6]=2000000000;

        bonusAwards = 30000000;
    }

    public int[] getAwards() {
        return awards;
    }

    public int getBonusAwards() {
        return bonusAwards;
    }
}
