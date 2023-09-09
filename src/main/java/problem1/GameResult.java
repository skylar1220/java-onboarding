package problem1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GameResult {
    POBI_WIN(1), CRONG_WIN(2), DRAW(0);

    private int result;

    GameResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

}
