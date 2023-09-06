package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> moneyCountList = new ArrayList<>();
        List<Integer> moneyList = List.of(50000, 10000, 5000, 1000, 500, 50, 10, 1);
        int change = money;
        int moneyCount = 0;
        for (int i = 0; i < moneyList.size(); i++) {
            moneyCount = change / moneyList.get(i);
            change %= moneyList.get(i);
            moneyCountList.add(moneyCount);
        }
        return moneyCountList;
    }


}
