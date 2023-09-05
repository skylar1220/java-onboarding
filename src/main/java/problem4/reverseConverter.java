package problem4;

import java.util.ArrayList;
import java.util.List;

public class reverseConverter {

    public static void main(String[] args) {
        List<Integer> parseNumberList = new ArrayList<>();
        for (int i = 25; i > -26; i = i - 2) {
            parseNumberList.add(i);
        }
        String inputWord = "I love you";
        int wordIndex = 0 ;
        StringBuffer result = new StringBuffer();
        int alphabetOrder = 0;
        char reversedAlphabet = 0;

        while (wordIndex < inputWord.length()) {
            char inputAlphabet = inputWord.charAt(wordIndex);
            if (inputAlphabet == ' ') {
                result.append(' ');
                wordIndex++;
                continue;
            }
            if (inputAlphabet > 64 && inputAlphabet < 91) {
                alphabetOrder = inputAlphabet - 65;
            }
            if ( inputAlphabet >96 && inputAlphabet < 123) {
                alphabetOrder = inputAlphabet - 97;
            }
            reversedAlphabet = (char) (inputAlphabet + parseNumberList.get(alphabetOrder));
            result.append(reversedAlphabet);
            wordIndex++;
        }
        System.out.println(result);
    }
}
