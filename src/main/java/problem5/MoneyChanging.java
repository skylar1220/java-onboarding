package problem5;

import java.util.ArrayList;
import java.util.List;

public class MoneyChanging {
    public List<Integer> getMoneyCountList(int money) {
        List<Integer> moneyCountList = new ArrayList<>();
        for (Money m : Money.highestOrder()) {
            int count = money / m.getValue();
            moneyCountList.add(count);
            money = money % m.getValue();
        }
        return moneyCountList;
    }
}
