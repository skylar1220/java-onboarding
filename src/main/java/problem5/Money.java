package problem5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Money {
    _50_000(50000), _10_000(10000), _5_000(5000),
    _1_000(1000),  _500(500), _100(100),
    _50(50),  _10(10), _1(1);

    private int value;

    Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<Money> highestOrder() {
        return Arrays.stream((values()))
            .sorted((o1, o2)-> o2.value - o1.value)
            .collect(Collectors.toList());
    }


}
