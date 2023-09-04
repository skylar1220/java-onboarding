package problem1;

import java.util.List;

public class Referee {

    private final Player pobi;
    private final Player crong;

    public Referee(List<Integer> pobi, List<Integer> crong) {
        ValidateUtil.validate(pobi, crong);
        this.pobi = new Player(pobi);
        this.crong = new Player(crong);
    }

    public GameResult playGame() {
        int pobiScore = pobi.calculateTotalScore();
        int crongScore = pobi.calculateTotalScore();
        return playGame(pobiScore, crongScore);
    }

    private GameResult playGame(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return GameResult.POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return GameResult.CRONG_WIN;
        }
        return GameResult.DRAW;
    }


}
