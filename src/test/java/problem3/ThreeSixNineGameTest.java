package problem3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ThreeSixNineGameTest {

    private ThreeSixNineGame threeSixNineGame;


    @Test
    void 숫자까지_쳐야하는_박수_횟수_확인하는_기능() {
        int result = new ThreeSixNineGame_Strem().playGame(31);
        assertThat(result).isEqualTo(11);
    }

}
