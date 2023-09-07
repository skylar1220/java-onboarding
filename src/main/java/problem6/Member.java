package problem6;

public class Member {

    private final String email;
    private final String name;

    public Member(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
