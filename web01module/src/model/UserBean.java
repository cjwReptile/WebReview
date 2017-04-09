package model;

/**
 * Created by cjw on 2017/4/7.
 */
public class UserBean {

    private String userId;

    private String passWord;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserId() {

        return userId;
    }

    public String getPassWord() {
        return passWord;
    }
}
