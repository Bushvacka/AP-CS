import java.util.Scanner;
public class StringUtilDriver {
	static String reversed, pigLatin, shorthand;
	static boolean palindrome;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string to reverse it: ");
		reversed = StringUtil.reverseString(scan.nextLine());
		System.out.println("Reversed string: " + reversed);
		System.out.print("Enter a sentence to check if it is a palindrome: ");
		palindrome = StringUtil.determinePalindrome(scan.nextLine());
		if (palindrome) {
			System.out.println("Your sentence is a palindrome");
		}
		else {
			System.out.println("Your sentence is not a palindrome");
		}
		System.out.print("Enter a sentence to convert to pig latin: ");
		pigLatin = StringUtil.pigLatin(scan.nextLine());
		System.out.println("Pig Latin Sentence: " + pigLatin);
		System.out.print("Enter a sentence to convert to shorthand: ");
		shorthand = StringUtil.shortHand(scan.nextLine());
		System.out.println("Shorthand Sentence: " + shorthand);
		scan.close();
	}
}
