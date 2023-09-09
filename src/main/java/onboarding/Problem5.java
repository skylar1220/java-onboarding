package onboarding;

import java.util.Collections;
import java.util.List;
import problem5.MoneyChanging;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = MoneyChanging.getMoneyCountList(money);
        return answer;
    }
}
