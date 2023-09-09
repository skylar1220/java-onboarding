package problem1;

import java.util.List;

public class Player {

    private static final int INIT_ADD_VLAUE = 0;
    private static final int INIT_MULTIPLE_VLAUE = 1;
    private static final int LOOP_CRITERION = 0;
    private static final int DIVIDE_CRITERION = 10;
    public static final int LEFT_PAGE_INDEX = 0;
    public static final int RIGHT_PAGE_INDEX = 1;

    private final List<Integer> page;

    public Player(List<Integer> page) {
        this.page = page;
    }

    public int addDigitNumber(int num) {
        int result = INIT_ADD_VLAUE;
        while (num != LOOP_CRITERION) {
            result = result + num % DIVIDE_CRITERION;
            num = num / DIVIDE_CRITERION;
        }
        return result;
    }

    public int multipleDigitNumber(int num) {
        int result = INIT_MULTIPLE_VLAUE;
        while (num != LOOP_CRITERION) {
            result = result * (num % DIVIDE_CRITERION);
            num = num / DIVIDE_CRITERION;
        }
        return result;
    }

    public int calculateMaxNumber(int num, int compareNum) {
        return Math.max(num, compareNum);
    }

    public int calculateLeftPageMaxNumber() {
        return calculateMaxNumber(addDigitNumber(page.get(LEFT_PAGE_INDEX)),
            multipleDigitNumber(page.get(LEFT_PAGE_INDEX)));
    }

    public int calculateRightPageMaxNumber() {
        return calculateMaxNumber(addDigitNumber(page.get(RIGHT_PAGE_INDEX)),
            multipleDigitNumber(page.get(RIGHT_PAGE_INDEX)));
    }

    public int calculateTotalScore() {
        return calculateMaxNumber(calculateLeftPageMaxNumber(), calculateRightPageMaxNumber());
    }
}
