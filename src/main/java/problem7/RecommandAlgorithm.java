package problem7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RecommandAlgorithm {

    public static List<User> RECOMMAND_LIST = new ArrayList<>();
    public static final int INIT_INDEX = 0;
    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static final int ZERO_SCORE = 0;
    public static final int SUBLIST_START = 0;
    public static final int SUBLIST_END = 0;
    public static final int SUBLIST_SIZE = 5;
    ListConverter listConverter = new ListConverter();

    public List<String> getRecommandList(String userForm, List<List<String>> friendsForm,
        List<String> visitorsForm) {
        List<User> friendsList = listConverter.getFriendsList(userForm, friendsForm);
        setFriendsScore(friendsList);
        listConverter.setAlreadyFriendList(userForm, friendsForm);

        List<User> visitorsList = listConverter.getUserList(visitorsForm);
        setVisitorScore(visitorsList);

        List<String> result = sortRecommandList();
        return result;
    }

    private void setFriendsScore(List<User> friendsList) {
        int index = INIT_INDEX;
        while (index < friendsList.size()) {
            User user = friendsList.get(index);
            if (isExistUser(user)) {
                User existUser = getExistUser(user);
                setRecommandScore(existUser, FRIEND_SCORE);
            }
            if (!isExistUser(user)) {
                setRecommandUser(user);
                setRecommandScore(user, FRIEND_SCORE);
            }
            index++;
        }
    }

    private void setVisitorScore(List<User> visitorsList) {
        int index = INIT_INDEX;
        while (index < visitorsList.size()) {
            User user = visitorsList.get(index);
            if (isExistUser(user)) {
                User existUser = getExistUser(user);
                setRecommandScore(existUser, VISITOR_SCORE);
            }
            if (!isExistUser(user)) {
                setRecommandUser(user);
                setRecommandScore(user, VISITOR_SCORE);
            }
            index++;
        }
    }

    private boolean isExistUser(User inputUser) {
        int recommandIndex = INIT_INDEX;
        while (recommandIndex < RECOMMAND_LIST.size()) {
            String inputUserId = inputUser.getId();
            String compareUserId = RECOMMAND_LIST.get(recommandIndex).getId();
            if (inputUserId.equals(compareUserId)) {
                return true;
            }
            recommandIndex++;
        }
        return false;
    }

    private User getExistUser(User inputUser) {
        int recommandIndex = INIT_INDEX;
        while (recommandIndex < RECOMMAND_LIST.size()) {
            String inputUserId = inputUser.getId();
            String compareUserId = RECOMMAND_LIST.get(recommandIndex).getId();
            User compareUser = RECOMMAND_LIST.get(recommandIndex);
            if (inputUserId.equals(compareUserId)) {
                return compareUser;
            }
            recommandIndex++;
        }
        return null;
    }

    public void setRecommandUser(User user) {
        RECOMMAND_LIST.add(user);
    }

    public void setRecommandScore(User user, int score) {
        user.setScore(user.getScore() + score);
    }

    private List<String> sortRecommandList() {
        RECOMMAND_LIST = listConverter.removeAlreadyFriend(RECOMMAND_LIST, RECOMMAND_LIST);
        sortByScoreAndId();
        sliceFiveUser();
        removeZeroScore();
        List<String> resultList = getIdList();
        return resultList;
    }

    private void sortByScoreAndId() {
        RECOMMAND_LIST.sort(Comparator.comparing(User::getScore).reversed().thenComparing(User::getId));
    }

    private void sliceFiveUser() {
        if (RECOMMAND_LIST.size() > SUBLIST_SIZE) {
            RECOMMAND_LIST = RECOMMAND_LIST.subList(SUBLIST_START, SUBLIST_END);
        }
    }

    private List<String> getIdList() {
        int resultIndex = INIT_INDEX;
        List<String> resultList = new ArrayList<>();
        while (resultIndex < RECOMMAND_LIST.size()) {
            resultList.add(RECOMMAND_LIST.get(resultIndex).getId());
            resultIndex++;
        }
        return resultList;
    }

    private void removeZeroScore() {
        int recommandIndex = INIT_INDEX;
        while (recommandIndex < RECOMMAND_LIST.size()) {
            if (RECOMMAND_LIST.get(recommandIndex).getScore() == 0) {
                RECOMMAND_LIST.remove(recommandIndex);
            }
            recommandIndex++;
        }
    }

}
