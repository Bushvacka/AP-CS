
//Troy Dutton
//Convert between Roman Numerals and Arabic
//10/29/19
import java.util.Arrays;

public class NumeralTranslator {
	final static String RNChars = "IVXLCDM";
	final static int[] RNValues = { 1, 5, 10, 50, 100, 500, 1000 };

	final static String[] ERNChars = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
	final static int[] ERNValues = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

	public static String AtoRN(int arabic) {
		for (int i = ERNValues.length - 1; i >= 0; i--) {
			if (arabic < ERNValues[i]) {
			} else {
				if (arabic == ERNValues[i]) {
					return ERNChars[i];
				}
				return ERNChars[i] + AtoRN(arabic - ERNValues[i]);
			}
		}
		return "";
	}

	public static int RNtoA(String RNum) {
		int[] vals = {};
		for (int i = 0; i < RNum.length(); i++) {
			addElement(vals, parseRN(RNum.charAt(i)));
		}
		int arabic = 0;
		int curVal;
		int lastVal = 0;
		for (int i = RNum.length() - 1; i >= 0; i--) {
			if (lastVal == 0) {
				lastVal = parseRN(RNum.charAt(i));
				arabic += lastVal;
			} else {
				curVal = parseRN(RNum.charAt(i));
				if (lastVal / curVal == 5 || lastVal / curVal == 10) {
					arabic -= curVal;
				} else {
					arabic += curVal;
				}
				lastVal = curVal;
			}
		}
		if (arabic > 3999) {
			return -1;
		}
		return arabic;
	}

	private static int[] addElement(int[] array, int element) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = element;
		return array;
	}

	private static int parseRN(char RNum) {
		return RNValues[RNChars.indexOf(RNum)];
	}
}
