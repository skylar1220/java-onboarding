package problem1;

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
