public class StringUtil {
	public static String reverseString(String string) {
		String reversed = new String();
		for (int i = string.length() - 1; i >= 0; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}
	
	private static String removeSpaces(String string) {
		return arrayToString(string.split(" "), false);
	}

	public static boolean determinePalindrome(String msg) {
		return removeSpaces(reverseString(msg).toLowerCase()).compareTo(removeSpaces(msg.toLowerCase())) == 0;
	}

	public static String pigLatin(String msg) {
		String[] PLArray = msg.split("\\s");// Create an array of each word in the message
		// Loop through each character
		for (int c = 0; c < PLArray.length; c++) {
			if (!PLArray[c].toLowerCase().contains("a") && !PLArray[c].toLowerCase().contains("e") && 
					!PLArray[c].toLowerCase().contains("i") && !PLArray[c].toLowerCase().contains("o") && !PLArray[c].toLowerCase().contains("u")) {// If the word contains no vowels
				PLArray[c] += "ay";// Add "ay" to the end of the word
			} else if ("aeiouAEIOU".contains(String.valueOf(PLArray[c].charAt(0)))) {// Else if the word starts with a vowel
				PLArray[c] += "yay";// Add "yay' to the end of the word
			} else {// Otherwise
				String[] splitWord = PLArray[c].split("[aeiouAEIOU]+", 2);// Split the word on the first vowel
				String start = splitWord[0];// String before vowel
				String end = splitWord[1];// String after vowel
				String vowel = PLArray[c].split("[^aeiouAEIOU]+")[1];// Vowel being split on
				if (Character.isUpperCase(start.charAt(0))) {// If the start of the word was uppercase
					start = start.toLowerCase();// Make the start of the word lowercase
					vowel = vowel.toUpperCase();// Make the new start of the
																							// word uppercase
				}
				PLArray[c] = vowel + end + start + "ay";// Assign the rearranged word
			}
		}
		return arrayToString(PLArray);
	}

	public static String shortHand(String msg) {
		String[] shorthand = msg.split("\\s");
		for (int i = 0; i < shorthand.length; i++) {
			if (shorthand[i].equalsIgnoreCase("and")) {
				shorthand[i] = "&";
			} else if (shorthand[i].equalsIgnoreCase("to")) {
				shorthand[i] = "2";
			} else if (shorthand[i].equalsIgnoreCase("you")) {
				shorthand[i] = "U";
			} else if (shorthand[i].equalsIgnoreCase("for")) {
				shorthand[i] = "4";
			}
			shorthand[i] = arrayToString(shorthand[i].replaceAll(" ", "").split("[aeiouAEIO]+"), false);
		}

		return arrayToString(shorthand);
	}

	private static String arrayToString(String[] array) {
		String string = new String();
		for (String substring : array) {
			string += substring + " ";
		}
		return string;
	}

	private static String arrayToString(String[] array, boolean spaces) {
		String string = new String();
		for (String substring : array) {
			if (spaces) {
				string += substring + " ";
			} else {
				string += substring;
			}
		}
		return string;
	}
}
