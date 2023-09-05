package problem3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ThreeSixNineGameTest {

    private ThreeSixNineGame threeSixNineGame;

    @Test
    void 숫자369_포함하는_경우() {
        boolean result = ThreeSixNineGame.contain369(9);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 숫자369_포함안하는_경우() {
        boolean result = ThreeSixNineGame.contain369(7);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 박수쳐야하는_숫자가_맞는_경우() {
        boolean result = ThreeSixNineGame.clapOrNot(192);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 박수쳐야하는_숫자가_아닌_경우() {
        boolean result = ThreeSixNineGame.clapOrNot(112);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 숫자까지_쳐야하는_박수_횟수_확인하는_기능() {
        int result = ThreeSixNineGame.playGame(31);
        assertThat(result).isEqualTo(11);
    }

}
