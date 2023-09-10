package onboarding;

import static onboarding.Problem6.addWordFromName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import problem6.Checker;
import problem6.ListConverter;
import problem6.Member;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        ListConverter listConverter = new ListConverter();
        List<Member> memberList = listConverter.getMemberList(forms);
        memberList = new Checker(memberList).getDuplicatedList();
        List<String> answer = listConverter.getEmailList(memberList);
        return answer;
    }

    public static List<String> solution_stream(List<List<String>> forms) {
        Map<String, List<String>> twoLetters = new HashMap<>();
        forms.stream().forEach(form -> addWordFromName(twoLetters, getName(form), getEmail(form)));
        List<String> result = twoLetters.values().stream()
            .filter(emailList -> emailList.size() > 1)
            .flatMap(Collection::stream)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        return result;
    }

    private static String getEmail(List<String> form) {
        return form.get(0);
    }

    private static String getName(List<String> form) {
        return form.get(1);
    }

    public static void addWordFromName(Map<String, List<String>> twoLetters, String name,
        String email) {
        String word = "";
        for (int i = 0; i < name.length() - 1; i++) {
            word = name.substring(i, i + 2);
            twoLetters.computeIfAbsent(word, x -> new ArrayList<>()).add(email);
        }
    }
}
