package problem5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import onboarding.Problem5;
import org.junit.jupiter.api.Test;

public class MoneyChangingTest {
    @Test
    void 화폐별_갯수_리스트_반환하는_기능(){
        List<Integer> result = Problem5.solution(7501);
        assertThat(result).isEqualTo(List.of(0, 0, 1, 2, 1, 0, 0, 1));
    }
}
