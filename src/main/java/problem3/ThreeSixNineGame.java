package problem3;

public class ThreeSixNineGame {

    public static final int DIVIDE_CRITERION = 10;
    public static final int LOOP_START_NUMBER = 1;
    public static final int INIT_CLAP_COUNT_VALUE = 0;
    public static final int INIT_CHECK_NUMBER_VALUE = 0;
    public static final int TARGETNUMBER_CRITERION = 0;
    public static final int NUMBER_DEVIDION = 3;
    public static final int NUMBER_ZERO_CRITERION = 0;

    public static int playGame(int loopEndNumber) {
        int loopTargerNumber = LOOP_START_NUMBER;
        int clapCount = INIT_CLAP_COUNT_VALUE;

        while (loopTargerNumber <= loopEndNumber) {
            if (clapOrNot(loopTargerNumber)) {
                clapCount++;
            }
            loopTargerNumber++;
        }
        return clapCount;
    }

    public static boolean clapOrNot(int number) {
        int targetNumber = number;
        int checkNumber = INIT_CHECK_NUMBER_VALUE;

        while (targetNumber != TARGETNUMBER_CRITERION) {
            checkNumber = targetNumber % DIVIDE_CRITERION;
            if (contain369(checkNumber)) {
                return true;
            }
            targetNumber /= DIVIDE_CRITERION;
        }
        return false;
    }

    public static boolean contain369(int number) {
        if (number == NUMBER_ZERO_CRITERION) {
            return false;
        }
        if (number % NUMBER_DEVIDION == NUMBER_ZERO_CRITERION) {
            return true;
        }
        return false;
    }

}
