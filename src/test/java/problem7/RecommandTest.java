package problem7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import onboarding.Problem7;
import org.junit.jupiter.api.Test;

public class RecommandTest {

    @Test
    void 추천_사용자_반환_기능() {
        String user = "mrko";
        List<List<String>> friends = List.of(List.of("donut", "andole"), List.of("donut", "jun"),
            List.of("donut", "mrko"), List.of("shakevan", "andole"), List.of("shakevan", "jun"),
            List.of("shakevan", "mrko"));
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = Problem7.solution(user, friends, visitors);
        assertThat(result).isEqualTo(List.of("andole", "jun", "bedi"));
    }

    @Test
    void 스트림_버전() {
        String user = "mrko";
        List<List<String>> friends = List.of(List.of("donut", "andole"), List.of("donut", "jun"),
            List.of("donut", "mrko"), List.of("shakevan", "andole"), List.of("shakevan", "jun"),
            List.of("shakevan", "mrko"));
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = Problem7.solution_stream(user, friends, visitors);
        assertThat(result).isEqualTo(List.of("andole", "jun", "bedi"));
    }
}
