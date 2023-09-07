package problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Checker {

    private static final Set<Member> DUPLICATED_MEMBER_SET = new HashSet<>();
    private static final int INIT_INDEX = 0;
    private static final int TARGET_NAME_LENGTH_MINUS_VALUE = 1;
    private static final int PART_INDEX_SUBSTRING_VALUE = 2;
    private final List<Member> memberList;

    public Checker(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<Member> getDuplicationMemberList() {
        int compareIndex = INIT_INDEX;
        while (compareIndex < memberList.size()) {
            Member compareMember = memberList.get(compareIndex);
            if (checkAlredyInSet(compareMember)) {
                compareIndex++;
                continue;
            }
            addOrNotToDuplicationList(compareMember);
            compareIndex++;
        }
        List<Member> duplicatedMemberList = new ArrayList<>(DUPLICATED_MEMBER_SET);
        return duplicatedMemberList;
    }

    private void addOrNotToDuplicationList(Member compareMember) {
        int targetIndex = INIT_INDEX;
        while (targetIndex < memberList.size()) {
            Member targetMember = memberList.get(targetIndex);
            if (targetMember == compareMember) {
                targetIndex++;
                continue;
            }
            if (containsPart(targetMember, compareMember)) {
                DUPLICATED_MEMBER_SET.add(targetMember);
                DUPLICATED_MEMBER_SET.add(compareMember);
            }
            targetIndex++;
        }
    }

    private boolean containsPart(Member targetMember, Member compareMember) {
        String targetName = targetMember.getName();
        String compareName = compareMember.getName();
        String targetPart = "";
        int partIndex = INIT_INDEX;
        while (partIndex < targetName.length() - TARGET_NAME_LENGTH_MINUS_VALUE) {
            targetPart = targetName.substring(partIndex, partIndex + PART_INDEX_SUBSTRING_VALUE);
            if (compareName.contains(targetPart)) {
                return true;
            }
            partIndex++;
        }
        return false;
    }

    private boolean checkAlredyInSet(Member compareMember) {
        if (DUPLICATED_MEMBER_SET.contains(compareMember)) {
            return true;
        }
        return false;
    }
}
