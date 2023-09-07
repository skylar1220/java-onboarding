package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import problem6.DuplicationCheck;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        DuplicationCheck duplicationCheck = new DuplicationCheck(forms);
        duplicationCheck.check();
        return answer;
    }
    public static void main(String[] args) {
        List<List<String>> nameList = new ArrayList<>(); // = forms
        nameList.add(List.of("1jm@email.com", "1제이엠"));
        nameList.add(List.of("2jason@email.com", "2제이슨"));
        nameList.add(List.of("3hyeonji@email.com", "3현지야"));
        nameList.add(List.of("4leehyeonji@email.com", "4이현지"));
        nameList.add(List.of("5no@email.com", "5아님이"));
        DuplicationCheck duplicationCheck = new DuplicationCheck(nameList);
        System.out.println(duplicationCheck.check());
    }
}
