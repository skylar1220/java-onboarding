package problem3;

import java.util.stream.IntStream;

public class ThreeSixNineGame_Strem {

    public final int DIVIDE_CRITERION = 10;
    public final int INIT_VALUE = 0;
    public final int CLAP_THREE = 3;
    public final int CLAP_SIX = 6;
    public final int CLAP_NINE = 9;

    public int playGame(int EndNumber) {
        int result = IntStream.range(1, EndNumber+1)
            .map(this::getCount)
            .sum();
        return result;
    }

    private int getCount(int number) {
        int clapCount = INIT_VALUE;
        if (clapOrNot(number)) {
            clapCount++;
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
        if (number == CLAP_THREE ||number == CLAP_SIX ||number == CLAP_NINE  ) {
            return true;
        }
        return false;
    }

}
