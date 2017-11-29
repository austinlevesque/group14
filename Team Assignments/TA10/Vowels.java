public class Vowels {

	public static int numOfVowels (String aString) {
		if (aString.length() == 0) {
			return 0;
		}
		else if (aString.substring(0,1).equals("a")) {
			return 1 + numOfVowels(aString.substring(1));
		}
		else if (aString.substring(0,1).equals("e")) {
			return 1 + numOfVowels(aString.substring(1));
		}
		else if (aString.substring(0,1).equals("i")) {
			return 1 + numOfVowels(aString.substring(1));
		}
		else if (aString.substring(0,1).equals("o")) {
			return 1 + numOfVowels(aString.substring(1));
		}
		else if (aString.substring(0,1).equals("u")) {
			return 1 + numOfVowels(aString.substring(1));
		}
		return numOfVowels(aString.substring(1));
	}
}
