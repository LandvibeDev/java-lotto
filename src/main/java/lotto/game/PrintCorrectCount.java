package lotto.game;

public class PrintCorrectCount {
    private final int[] prize;

    public PrintCorrectCount(int [] prizeParam){
        prize = prizeParam;
    }

    public void print(double temp){
        System.out.println("3개 일치 (5,000원) - " +  prize[5]+ "개\n" +
                "4개 일치 (50,000원) - " +  prize[4]+ "개\n" +
                "5개 일치 (1,500,000원) - " +  prize[3]+ "개\n"+
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " +  prize[2]+ "개\n" +
                "6개 일치 (2,000,000,000원) - " +  prize[1]+ "개\n" +
                "총 수익률은 " + temp + "%입니다."
                );

    }
}
