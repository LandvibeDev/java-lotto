package lotto;

public class Printer {
	public void printResult(int[] rankings, double totalReward, double purchaseAmount) {
		double profitRatio = 0;
		System.out.println("당첨 통계\n" + "---");
		System.out.print("3개 일치 (5,000원) - ");
		System.out.println(rankings[5] + "개");
		System.out.print("4개 일치 (50,000원) - ");
		System.out.println(rankings[4] + "개");
		System.out.print("5개 일치 (1,500,000원) - ");
		System.out.println(rankings[3] + "개");
		System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
		System.out.println(rankings[2] + "개");
		System.out.print("6개 일치 (2,000,000,000원) - ");
		System.out.println(rankings[1] + "개");
		profitRatio = (totalReward / purchaseAmount) * 100.0;
		System.out.printf("총 수익률은 %.1f", profitRatio);
		System.out.println("%입니다.");

	}
}
