package problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListConverter {

    private static final int EMAIL_INDEX = 0;
    private static final int NAME_INDEX = 1;

    public ListConverter() {
    }

    public List<Member> getMemberList(List<List<String>> forms) {
        List<Member> memberList = new ArrayList<>();
        for (List<String> memberForm : forms) {
            String email = memberForm.get(EMAIL_INDEX);
            String name = memberForm.get(NAME_INDEX);
            memberList.add(new Member(email, name));
        }
        return memberList;
    }

    public List<String> getEmailList(List<Member> memberList) {
        Set<String> emailSet = new HashSet<>();
        for (Member member : memberList) {
            emailSet.add(member.getEmail());
        }
        List<String> emailList = new ArrayList<>(emailSet);
        Collections.sort(emailList);
        return emailList;
    }
}
