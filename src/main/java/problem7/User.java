package problem7;

public class User {
    private final String id;
    private int score;

    public User(String id, int score) {
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
       this.score = score;
    }
}
