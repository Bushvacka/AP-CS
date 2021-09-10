//Troy Dutton
//Provide user input to FunLoops
//11/12/19
import java.util.Scanner;
public class FunLoopDriver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("\nNum of Magic Squares(Max 13): " );
		int n = input.nextInt();
		if (n > 13) {
			n = 13;
		}
		FunLoops.magicSquares(n);
		input.close();
	}
}
