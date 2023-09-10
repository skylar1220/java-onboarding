package problem4;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Converter {
    private char BLANK = ' ';

    public String reverseWord(String word) {
        StringBuilder result = new StringBuilder();
        char [] alphabetArray = word.toCharArray();
        for (char alphabet: alphabetArray) {
            result.append(convertAlphabet(alphabet));
        }
        return result.toString();
    }

    private char convertAlphabet(char alphabet) {
        char result = ' ';
        if (Character.isUpperCase(alphabet)) {
            result = (char) ('Z' - (alphabet - 'A'));
        }
        if (Character.isLowerCase(alphabet)) {
            result = (char) ('z' - (alphabet - 'a'));
        }
        if (alphabet == BLANK) {
            result = BLANK;
        }
        return result;
    }
}
