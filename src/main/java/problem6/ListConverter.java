package problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListConverter {

    private static final int INIT_INDEX = 0;
    private static final int EMAIL_INDEX = 0;
    private static final int NAME_INDEX = 1;

    public ListConverter() {
    }

    public List<Member> getMemberList(List<List<String>> forms) {
        List<Member> memberList = new ArrayList<>();
        int formsIndex = INIT_INDEX;
        while (formsIndex < forms.size()) {
            String email = forms.get(formsIndex).get(EMAIL_INDEX);
            String name = forms.get(formsIndex).get(NAME_INDEX);
            Member member = new Member(email, name);
            memberList.add(member);
            formsIndex++;
        }
        return memberList;
    }

    public List<String> getEmailList(List<Member> memberList) {
        Set<String> emailSet = new HashSet<>();
        int memberListIndex = INIT_INDEX;
        while (memberListIndex < memberList.size()) {
            emailSet.add(memberList.get(memberListIndex).getEmail());
            memberListIndex++;
        }
        List<String> emailList = new ArrayList<>(emailSet);
        Collections.sort(emailList);
        return emailList;
    }
}
