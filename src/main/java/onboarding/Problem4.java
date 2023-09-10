package onboarding;

import problem4.Converter;

public class Problem4 {
    public static String solution(String word) {
        String result = new Converter().reverseWord(word);
        return result;
    }
}
