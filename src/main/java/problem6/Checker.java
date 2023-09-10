package problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Checker {
    private final List<Member> MEMBER_LIST;

    public Checker(List<Member> memberList) {
        MEMBER_LIST = memberList;
    }

    public List<Member> getDuplicatedList() {
        Set<Member> resultSet = new HashSet<>();
        for (Member member : MEMBER_LIST) {
            if (!containsInSet(member, resultSet)) {
                resultSet = addToSet(member, resultSet);
            }
        }
        return new ArrayList<>(resultSet);
    }

    private Set<Member> addToSet(Member member, Set<Member> resultSet) {
        for (Member compareMember : MEMBER_LIST) {
            if (!isSameMember(member, compareMember) && containsSamePart(member, compareMember)) {
                resultSet.add(member);
                resultSet.add(compareMember);
            }
        }
        return resultSet;
    }

    private boolean containsSamePart(Member member, Member compareMember) {
        for (String split : member.nameSplitList()) {
            if (compareMember.getName().contains(split)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameMember(Member member, Member compareMember) {
        if (member.getName() == compareMember.getName()) {
            return true;
        }
        return false;
    }

    private boolean containsInSet(Member member, Set<Member> set) {
        if (set.contains(member)) {
            return true;
        }
        return false;
    }

}
