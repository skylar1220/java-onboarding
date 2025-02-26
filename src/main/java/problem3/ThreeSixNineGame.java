package problem3;

public class ThreeSixNineGame {

    public final int DIVIDE_CRITERION = 10;
    public final int INIT_VALUE = 0;
    public final int MULTIPLE_OF_THREE = 3;

    public int playGame(int endNumber) {
        int clapCount = INIT_VALUE;

        for (int i = 0; i < endNumber; i++) {
            int number = i;
            if (clapOrNot(number)) {
                clapCount++;
            }
        }
        return clapCount;
    }

    private boolean clapOrNot(int targetNumber) {
        while (targetNumber != 0) {
            int firstDigit = targetNumber % DIVIDE_CRITERION;
            if (contain369(firstDigit)) {
                return true;
            }
            targetNumber /= DIVIDE_CRITERION;
        }
        return false;
    }

    private boolean contain369(int number) {
        if (number == 0) {
            return false;
        }
        if (number % MULTIPLE_OF_THREE == 0) {
            return true;
        }
        return false;
    }

}
