package problem1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(List.of(233, 234));
    }

    @Test
    void 각자리수_더하는_기능() {
        int result = player.addDigitNumber(233);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void 각자리수_곱하는_기능() {
        int result = player.multipleDigitNumber(233);
        assertThat(result).isEqualTo(18);
    }

    @Test
    void 왼쪽페이지_계산_최대값_구하는_기능() {
        int result = player.calculateLeftPageMaxNumber();
        assertThat(result).isEqualTo(18);
    }

    @Test
    void 오른쪽페이지_계산_최대값_구하는_기능() {
        int result = player.calculateRightPageMaxNumber();
        assertThat(result).isEqualTo(24);
    }

    @Test
    void 한명의_계산_최대값_구하는_기능() {
        int result = player.calculateTotalScore();
        assertThat(result).isEqualTo(24);
    }
}
