package problem4;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

import java.util.ArrayList;
import java.util.List;

public class ReverseConverter {

    private static List<Integer> CONVERTER_NUMBER_LIST = new ArrayList<>();
    private static int CONVERT_NUMBER_LIST_LENGTH = 25;
    private static int CONVERT_NUMBER_LIST_CRITERION = -26;
    private static int CONVERT_NUMBER_LIST_DIFFERENCE = 2;
    private static int INT_INIT_VALUE = 0;
    private static char CAHR_INIT_VALUE = 0;
    private static char BLANK = ' ';
    private static char UPPER_CRITERION = 65;
    private static char LOWER_CRITERION = 97;

    public static void setConverterNumberList() {
        for (int i = CONVERT_NUMBER_LIST_LENGTH; i > CONVERT_NUMBER_LIST_CRITERION; i = i - CONVERT_NUMBER_LIST_DIFFERENCE) {
            CONVERTER_NUMBER_LIST.add(i);
        }
    }

    public static String loopWordConverter(String word) {
        int alphabetIndex = INT_INIT_VALUE;
        int converterIndex = INT_INIT_VALUE;
        char alphabet = CAHR_INIT_VALUE;
        char convertedAlphabet = CAHR_INIT_VALUE;
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
        return alphabet - UPPER_CRITERION;
    }

    private static int getLowerConverterIndex(char alphabet) {
        return alphabet - LOWER_CRITERION;
    }

    private static char convertAlphabet(char alphabet, int converterIndex) {
        return (char) (alphabet + CONVERTER_NUMBER_LIST.get(converterIndex));
    }
}
