//Troy Dutton
//Provide user input to NumeralTranslator
//10/29/19
import java.util.Scanner;
public class NumeralTranslatorDriver {
	static final char[] RNChars = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
	static String RNum;
	static int arabic;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Roman Numeral: ");
		RNum = scan.nextLine();
		arabic = NumeralTranslator.RNtoA(RNum.toUpperCase());
		if (arabic != -1) {
			System.out.println("Arabic Value: " + arabic);
		}
		else {
			System.out.println("Value More Than (3999)");
		}
		System.out.print("Arabic Number: ");
		arabic = scan.nextInt();
		if (arabic > 3999) {
			System.out.println("Value More Than (3999)");
		}
		else {
			RNum = NumeralTranslator.AtoRN(arabic);
			System.out.println("Roman Numeral Value: " + RNum);
		}
		scan.close();
	}
}
