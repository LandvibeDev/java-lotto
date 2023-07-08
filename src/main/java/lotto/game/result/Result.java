package lotto.game.result;

// strike ball count
public class Result {
    public int[] result = new int[10];
    public int bonusResult;

    public void upCountResult(int idx){
        result[idx]++;
    }
    public void downCountResult(int idx){
        result[idx]--;
    }
    public void upCountBonusResult(){
        bonusResult++;
    }

    public int[] getResult() {
        return result;
    }
    public int getBonusResult(){
        return bonusResult;
    }
}
