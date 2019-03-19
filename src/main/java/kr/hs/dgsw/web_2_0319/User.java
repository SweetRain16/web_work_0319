package kr.hs.dgsw.web_2_0319;

public class User {
    private String name;
    private String email;

    @Override
    public String toString() {
        return name + "/" + email;
    }

    public User(){}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
