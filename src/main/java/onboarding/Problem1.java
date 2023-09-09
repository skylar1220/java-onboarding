package onboarding;

import java.util.List;
import problem1.GameResult;
import problem1.Referee;

<<<<<<< HEAD
public class Problem1 {

    public static int EXCEPTION_GAME_RESULT = -1;

    public static int solution(List<Integer> Pobi, List<Integer> Crong) {
        try {
            Referee referee = new Referee(Pobi, Crong);
            GameResult gameResult = referee.playGame();
            return gameResult.getResult();
        } catch (Exception e) {
            return EXCEPTION_GAME_RESULT;
        }
=======
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
>>>>>>> parent of 17692b9 (cool@@)
    }

}