package onboarding;

import problem3.ThreeSixNineGame;

public class Problem3 {

    public static int solution(int number) {
        int result = new ThreeSixNineGame().playGame(number);
        return result;
    }
}
