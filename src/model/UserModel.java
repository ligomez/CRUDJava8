package model;

public class UserModel {
    private int userId;
    private String userName;
    private String userSurname;
    private String userEmail;

    public UserModel(int userId, String userName, String userSurname, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
    }

    public UserModel(String userName){
        this.userName = userName;
    }

    public UserModel(String userName, String userSurname, String userEmail) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return  userId + " - " + userName + " " + userSurname + " ";
    }
}
