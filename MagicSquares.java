//Troy Dutton
//Find Magic Squares and LCM’s
//11/12/19
public class MagicSquares {
	static int MNCount, lastDigit = 0;
	static long sum, num, startTime, endTime = 0;
	static long lastMN = 1;

	public static void magicSquares(int n) {
		startTime = System.currentTimeMillis();
		while (MNCount < n) {
			num++;
			sum += num;
			if ((sum*1.0) / lastMN >= 33.97 || sum == 1) {
				lastDigit = (int) (sum % 10);
				if ((lastDigit == 0 || lastDigit == 1 || lastDigit == 5 || lastDigit == 6)&& (Math.sqrt(sum) % 1 == 0)) {
					lastMN = sum;
					MNCount++;
					System.out.println("Magic Number(" + MNCount + "): " + sum);
				}
			}
		}
		endTime = System.currentTimeMillis();
		System.out.printf("Magic Numbers Finished: %d ms",  (endTime - startTime));
	}

}
