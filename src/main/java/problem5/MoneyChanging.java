package problem5;

import java.util.ArrayList;
import java.util.List;

public class MoneyChanging {

    private static List<Integer> MONEY_LIST = List.of(50000, 10000, 5000, 1000, 500, 50, 10, 1);
    private static int INIT_LOOP_VALUE = 0;
    private static int INIT_MONEY_COUNT = 0;

    private static int getMoneyCount(int change, int moneyIndex) {
        return change / MONEY_LIST.get(moneyIndex);
    }

    private static int getChange(int change, int moneyIndex) {
        return change % MONEY_LIST.get(moneyIndex);
    }

    public static List<Integer> getMoneyCountList(int money) {
        List<Integer> moneyCountList = new ArrayList<>();
        int change = money;
        int moneyCount = INIT_MONEY_COUNT;

        for (int i = INIT_LOOP_VALUE; i < MONEY_LIST.size(); i++) {
            moneyCount = getMoneyCount(change, i);
            change = getChange(change, i);
            moneyCountList.add(moneyCount);
        }
        return moneyCountList;
    }


}
