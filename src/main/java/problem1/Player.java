package problem1;

import java.util.List;

public class Player {

    private final int INIT_VLAUE = 0;
    private final int DIVIDE_CRITERION = 10;
    public final int LEFT_PAGE_INDEX = 0;
    public final int RIGHT_PAGE_INDEX = 1;

    private final List<Integer> page;

    public Player(List<Integer> page) {
        this.page = page;
    }

    public int addDigitNumber(int num) {
        int result = INIT_VLAUE;
        while (num != INIT_VLAUE) {
            result = result + num % DIVIDE_CRITERION;
            num = num / DIVIDE_CRITERION;
        }
        return result;
    }

    public int multipleDigitNumber(int num) {
        int result = INIT_VLAUE;
        while (num != INIT_VLAUE) {
            result = result * (num % DIVIDE_CRITERION);
            num = num / DIVIDE_CRITERION;
        }
        return result;
    }

    public int getMaxNumber(int num, int compareNum) {
        return Math.max(num, compareNum);
    }

    public int getLeftPageMaxNumber() {
        return getMaxNumber(addDigitNumber(page.get(LEFT_PAGE_INDEX)),
            multipleDigitNumber(page.get(LEFT_PAGE_INDEX)));
    }

    public int getRightPageMaxNumber() {
        return getMaxNumber(addDigitNumber(page.get(RIGHT_PAGE_INDEX)),
            multipleDigitNumber(page.get(RIGHT_PAGE_INDEX)));
    }

    public int getTotalScore() {
        return getMaxNumber(getLeftPageMaxNumber(), getRightPageMaxNumber());
    }
}
