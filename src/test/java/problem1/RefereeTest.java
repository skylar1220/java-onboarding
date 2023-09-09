package problem1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    @Test
    void 포비가_이기는_경우() {
        Referee referee = new Referee(List.of(123, 124), List.of(23, 24));
        assertThat(referee).isEqualTo(1);
    }

    @Test
    void 크롱이_이기는_경우() {
        Referee referee = new Referee(List.of(23, 24), List.of(123, 124));
        assertThat(referee).isEqualTo(2);
    }

    @Test
    void 무승부() {
        Referee referee = new Referee(List.of(23, 24), List.of(23, 24));
        assertThat(referee).isEqualTo(0);
    }

    @Test
    void 왼쪽페이지_홀수_오른쪽페이지_짝수가_아닌_경우() {
        assertThatThrownBy(() -> new Referee(List.of(24, 25), List.of(123, 124)))
            .isInstanceOf(IllegalAccessError.class)
            .hasMessage("올바르지 않은 입력입니다.");
    }

    @Test
    void 시작페이지가_범위밖인_경우() {
        assertThatThrownBy(() -> new Referee(List.of(-3, -2), List.of(123, 124)))
            .isInstanceOf(IllegalAccessError.class)
            .hasMessage("올바르지 않은 입력입니다.");
    }

    @Test
    void 마지막페이지가_범위밖인_경우() {
        assertThatThrownBy(() -> new Referee(List.of(401, 402), List.of(123, 124)))
            .isInstanceOf(IllegalAccessError.class)
            .hasMessage("올바르지 않은 입력입니다.");
    }
}
