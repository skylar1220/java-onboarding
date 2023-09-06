package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void main(String[] args) {

        List<List<String>> nameList = new ArrayList<>();
        nameList.add(List.of("jm@email.com", "제이엠"));
        nameList.add(List.of("jason@email.com", "제이슨"));
        nameList.add(List.of("jason@email.com", "아아제이슨이야"));
        nameList.add(List.of("jason@email.com", "이현지"));
        Set<String> duplicatedNameSet = new HashSet<>();
        for (int i = 0; i < nameList.size(); i++) {
            String compareName = nameList.get(i).get(1);
            if(duplicatedNameSet.contains(compareName)) {
                continue;
            }
            for (int j = 1; j < nameList.size(); j++) {
                if(i == j){
                    continue;
                }
                String targetName = nameList.get(j).get(1);
                if(checkContain(targetName, compareName)) {
                    duplicatedNameSet.add(targetName);
                    duplicatedNameSet.add(compareName);
                }
            }
        }
        System.out.println(duplicatedNameSet);
    }

    private static boolean checkContain(String targetName, String compareName) {
        String targetPart = "";
        for (int i = 0; i < targetName.length()-1; i++) {
            targetPart = targetName.substring(i, i+2);
            if (compareName.contains(targetPart)){
                return true;
            }
        }
        return false;
    }
}
