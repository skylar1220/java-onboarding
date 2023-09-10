package problem6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import onboarding.Problem6;
import org.junit.jupiter.api.Test;

public class DuplicationCheckTest {
    @Test
    void 중복이름의_이메일_리스트_반환_기능(){
        Problem6 problem6 = new Problem6();
        List<List<String>> forms = new ArrayList<>();
        forms.add(List.of("1jm@email.com", "1제이엠"));
        forms.add(List.of("2jason@email.com", "2제이슨"));
        forms.add(List.of("3hyeonji@email.com", "3현지야"));
        forms.add(List.of("4leehyeonji@email.com", "4이현지"));
        forms.add(List.of("5no@email.com", "5아님이"));
        List<String> answer = Problem6.solution(forms);
        assertThat(answer).isEqualTo(List.of("1jm@email.com","2jason@email.com", "3hyeonji@email.com", "4leehyeonji@email.com"));
    }

    @Test
    void 스트림_버전(){
        Problem6 problem6 = new Problem6();
        List<List<String>> forms = new ArrayList<>();
        forms.add(List.of("1jm@email.com", "1제이엠"));
        forms.add(List.of("2jason@email.com", "2제이슨"));
        forms.add(List.of("3hyeonji@email.com", "3현지야"));
        forms.add(List.of("4leehyeonji@email.com", "4이현지"));
        forms.add(List.of("5no@email.com", "5아님이"));
        List<String> answer = Problem6.solution_stream(forms);
        assertThat(answer).isEqualTo(List.of("1jm@email.com","2jason@email.com", "3hyeonji@email.com", "4leehyeonji@email.com"));
    }
}
