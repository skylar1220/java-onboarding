package onboarding;

import java.util.List;
import problem1.GameResult;
import problem1.Referee;

public class Problem1 {

    public static int EXCEPTION_GAME_RESULT = -1;

    public static int solution(List<Integer> Pobi, List<Integer> Crong) {
        try {
            GameResult gameResult = new Referee(Pobi, Crong).playGame();
            return gameResult.getResult();
        } catch (Exception e) {
            return EXCEPTION_GAME_RESULT;
        }
    }
}