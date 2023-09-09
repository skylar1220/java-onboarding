package onboarding;

import java.util.ArrayList;
import java.util.List;
import problem6.Checker;
import problem6.ListConverter;
import problem6.Member;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        ListConverter listConverter = new ListConverter();
        List<Member> memberList = listConverter.getMemberList(forms);
        Checker checker = new Checker(memberList);
        List<Member> duplicationMemberList = checker.getDuplicationMemberList();
        List<String> answer = listConverter.getEmailList(duplicationMemberList);
        return answer;
    }
}
