package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import problem7.RecommandAlgorithm;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = new RecommandAlgorithm().getRecommandList(user, friends, visitors);
        return answer;
    }

    public static List<String> solution_stream(String user, List<List<String>> friends,
        List<String> visitors) {
        Map<String, Integer> result = new HashMap<>();
        Set<String> alreadyFriend = new HashSet<>();

        processFriends(user, friends, result, alreadyFriend);
        processVisitors(visitors, result);
        return getSortedAndFilteredResult(result, alreadyFriend);
    }

    private static void processFriends(String user, List<List<String>> friends,
        Map<String, Integer> result, Set<String> alreadyFriend) {
        friends.stream()
            .filter(friend -> !Objects.equals(friend.get(1), user))
            .forEach(friend -> {
                addFriendMap(result, friend);
                addAlredayFriend(alreadyFriend, friend);
            });
    }

    private static List<String> getSortedAndFilteredResult(Map<String, Integer> result,
        Set<String> alreadyFriend) {
        return result.entrySet().stream()
            .filter(entry -> !alreadyFriend.contains(entry.getKey()))
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.<String, Integer>comparingByKey()))
            .limit(5)
            .filter(entry -> entry.getValue() != 0)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    private static void addAlredayFriend(Set<String> alreadyFriend, List<String> friend) {
        alreadyFriend.add(friend.get(0));
    }

    public static void addFriendMap(Map<String, Integer> users, List<String> friends) {
        String addingUser = friends.get(1);
        users.merge(addingUser, 10, Integer::sum);
    }

    private static void processVisitors(List<String> visitors, Map<String, Integer> users) {
        for (String user : visitors) {
            users.merge(user, 1, Integer::sum);
        }
    }


}
