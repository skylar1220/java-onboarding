package problem4;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

import java.util.ArrayList;
import java.util.List;

public class ReverseConverter {

    private static List<Integer> CONVERTER_NUMBER_LIST = new ArrayList<>();
    private static char BLANK = ' ';

    public static void setConverterNumberList() {
        for (int i = 25; i > -26; i = i - 2) {
            CONVERTER_NUMBER_LIST.add(i);
        }
    }

    public static String loopWordConverter(String word) {
        int alphabetIndex = 0;
        int converterIndex = 0;
        char alphabet = 0;
        char convertedAlphabet = 0;
        StringBuffer result = new StringBuffer();

        setConverterNumberList();
        while (alphabetIndex < word.length()) {
            alphabet = word.charAt(alphabetIndex);
            if (isBlank(alphabet)) {
                result.append(BLANK);
                alphabetIndex++;
                continue;
            }
            if (isUpperCase(alphabet)) {
                converterIndex = getUpperConverterIndex(alphabet);
                convertedAlphabet = convertAlphabet(alphabet, converterIndex);
            }
            if (isLowerCase(alphabet)) {
                converterIndex = getLowerConverterIndex(alphabet);
                convertedAlphabet = convertAlphabet(alphabet, converterIndex);
            }
            result.append(convertedAlphabet);
            alphabetIndex++;
        }
        return result.toString();
    }

    private static boolean isBlank(char alphabet) {
        return alphabet == ' ';
    }

    private static int getUpperConverterIndex(char alphabet) {
        return alphabet - 65;
    }

    private static int getLowerConverterIndex(char alphabet) {
        return alphabet - 97;
    }

    private static char convertAlphabet(char alphabet, int converterIndex) {
        return (char) (alphabet + CONVERTER_NUMBER_LIST.get(converterIndex));
    }
}
