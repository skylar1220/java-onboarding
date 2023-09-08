package onboarding;

import java.util.Collections;
import java.util.List;
import problem7.RecommandAlgorithm;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        RecommandAlgorithm recommandAlgorithm = new RecommandAlgorithm();
        List<String> answer = recommandAlgorithm.getRecommandList(user, friends, visitors);
        return answer;
    }
}
