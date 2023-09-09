package problem7;

import java.util.ArrayList;
import java.util.List;

public class ListConverter {

    public static List<User> ALREADY_FRIEND_LIST = new ArrayList<>();
    public static final int INIT_INDEX = 0;
    public static final int INIT_SCORE = 0;
    public static final int ALREDAY_FRIEND_INDEX = 0;
    public static final int USER_INDEX = 1;

    public List<User> getUserList(List<String> idForm) {
        List<User> userList = new ArrayList<>();
        int idIndex = INIT_INDEX;
        while (idIndex < idForm.size()) {
            String id = idForm.get(idIndex);
            User user = new User(id, INIT_SCORE);
            userList.add(user);
            idIndex++;
        }
        return userList;
    }

    public List<User> getFriendsList(String userFormId, List<List<String>> friendsForm) {
        int formIndex = INIT_INDEX;
        List<User> userList = new ArrayList<>();
        List<User> alreadyFriendList = new ArrayList<>();
        while (formIndex < friendsForm.size()) {
            String userId = friendsForm.get(formIndex).get(USER_INDEX);
            if (isSameWithUserForm(userFormId, userId)) {
                formIndex++;
                continue;
            }
            User user = new User(userId, INIT_SCORE);
            userList.add(user);
            formIndex++;
        }
        return userList;
    }

    public List<User> removeAlreadyFriend(List<User> recommandList, List<User> returRecommandList) {
        int alreadyFrinedIndex = INIT_INDEX;
        while (alreadyFrinedIndex < ALREADY_FRIEND_LIST.size()) {
            int recommandIndex = INIT_INDEX;
            while (recommandIndex < recommandList.size()) {
                String alreadyFriendId = ALREADY_FRIEND_LIST.get(alreadyFrinedIndex).getId();
                String recommandId = recommandList.get(recommandIndex).getId();
                if (alreadyFriendId.equals(recommandId)) {
                    returRecommandList.remove(recommandIndex); // 여기 확인@@
                }
                recommandIndex++;
            }
            alreadyFrinedIndex++;
        }
        return returRecommandList;
    }

    public void setAlreadyFriendList(String userFormId, List<List<String>> friendsForm) {
        int formIndex = INIT_INDEX;
        while (formIndex < friendsForm.size()) {
            String alredayFriendId = friendsForm.get(formIndex).get(ALREDAY_FRIEND_INDEX);
            User user = new User(alredayFriendId, INIT_SCORE);
            if (isExistUser(user, ALREADY_FRIEND_LIST)) {
                formIndex++;
                continue;
            }
            ALREADY_FRIEND_LIST.add(user);
            formIndex++;
        }
    }

    private boolean isExistUser(User inputUser, List<User> compareList) {
        int compareIndex = INIT_INDEX;
        while (compareIndex < compareList.size()) {
            String inputUserId = inputUser.getId();
            String compareUserId = compareList.get(compareIndex).getId();
            if (inputUserId.equals(compareUserId)) {
                return true;
            }
            compareIndex++;
        }
        return false;
    }

    private boolean isSameWithUserForm(String userFormId, String userId) {
        if (userFormId.equals(userId)) {
            return true;
        }
        return false;
    }


}

