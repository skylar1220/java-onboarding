package problem1;

import java.util.List;

public class ValidateUtil {

    private static final int TWO_PAGE_CRITERION = 2;
    private static final int CONTIOUS_CRITERION = 1;
    private static final int EVEN_CRITERION = 2;
    private static final int EVEN_DIVIDION = 0;
    private static final int START_PAGE_NUM_LEFT = 1;
    private static final int START_PAGE_NUM_RIGHT = 2;
    private static final int END_PAGE_NUM_LEFT = 399;
    private static final int END_PAGE_NUM_RIGHT = 400;
    private static final String INPUT_EXCEPTION_MESSAGE = "올바르지 않은 입력입니다.";

    public static void validate(List<Integer> pobi, List<Integer> crong) {
        validate(pobi);
        validate(crong);
    }

    public static void validate(List<Integer> player) {
        validateTwoPage(player);
        int leftPageNumber = player.get(Player.LEFT_PAGE_INDEX);
        int rightPageNumber = player.get(Player.RIGHT_PAGE_INDEX);
        validateContinuousPage(leftPageNumber, rightPageNumber);
        validateOddEvenPage(leftPageNumber, rightPageNumber);
        validateStartPage(leftPageNumber, rightPageNumber);
        validateEndPage(leftPageNumber, rightPageNumber);
    }

    private static void validateContinuousPage(int leftPageNumber, int rightPageNumber) {
        if (rightPageNumber - leftPageNumber != CONTIOUS_CRITERION) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateOddEvenPage(int leftPageNumber, int rightPageNumber) {
        if (leftPageNumber % EVEN_CRITERION == EVEN_DIVIDION
            || rightPageNumber % EVEN_CRITERION != EVEN_DIVIDION) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateStartPage(int leftPageNumber, int rightPageNumber) {
        if (leftPageNumber < START_PAGE_NUM_LEFT || rightPageNumber < START_PAGE_NUM_RIGHT) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateEndPage(int leftPageNumber, int rightPageNumber) {
        if (leftPageNumber < END_PAGE_NUM_LEFT || rightPageNumber < END_PAGE_NUM_RIGHT)
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
    }

    public static void validateTwoPage(List<Integer> player) {
        if (player.size() != TWO_PAGE_CRITERION) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

}
