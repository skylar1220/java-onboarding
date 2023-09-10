package problem6;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private final String email;
    private final String name;

    public Member(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public List<String> nameSplitList(){
        List<String> nameSplitList = new ArrayList<>();
        for (int i = 0; i < name.length() - 1; i++) {
            nameSplitList.add(name.substring(i, i + 2));
        }
        return nameSplitList;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
