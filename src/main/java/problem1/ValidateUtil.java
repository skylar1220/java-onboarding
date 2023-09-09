package problem1;

import java.util.List;

public class ValidateUtil {

    private final int EVEN_CRITERION = 2;
    private final int START_PAGE_NUM_LEFT = 1;
    private final int START_PAGE_NUM_RIGHT = 2;
    private final int END_PAGE_NUM_LEFT = 399;
    private final int END_PAGE_NUM_RIGHT = 400;
    private final int LEFT_PAGE_INDEX = 0;
    private final int RIGHT_PAGE_INDEX = 1;
    private final String INPUT_EXCEPTION_MESSAGE = "올바르지 않은 입력입니다.";

    public void validate(List<Integer> pobi, List<Integer> crong) {
        validate(pobi);
        validate(crong);
    }

    private void validate(List<Integer> player) {
        int leftPageNumber = player.get(LEFT_PAGE_INDEX);
        int rightPageNumber = player.get(RIGHT_PAGE_INDEX);
        validateContinuousPage(leftPageNumber, rightPageNumber);
        validateOddEvenPage(leftPageNumber, rightPageNumber);
        validateStartPage(leftPageNumber, rightPageNumber);
        validateEndPage(leftPageNumber, rightPageNumber);
    }

    private void validateContinuousPage(int leftPageNumber, int rightPageNumber) {
        if (rightPageNumber - leftPageNumber != 1) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private void validateOddEvenPage(int leftPageNumber, int rightPageNumber) {
        if (leftPageNumber % EVEN_CRITERION == 0
            || rightPageNumber % EVEN_CRITERION != 0) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private void validateStartPage(int leftPageNumber, int rightPageNumber) {
        if (leftPageNumber < START_PAGE_NUM_LEFT || rightPageNumber < START_PAGE_NUM_RIGHT) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private void validateEndPage(int leftPageNumber, int rightPageNumber) {
        if (leftPageNumber < END_PAGE_NUM_LEFT || rightPageNumber < END_PAGE_NUM_RIGHT) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

}
