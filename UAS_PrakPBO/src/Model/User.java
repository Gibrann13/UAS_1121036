/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gibran<>
 */
public class User {
    private int userId;
    private String userName;
    private String userEmail;
    private String userGender;
    private CatagoryUser catagoryUser = new CatagoryUser();
    private int userFollowers;

    public User(int userId, String userName, String userEmail, String userGender,CatagoryUser catagoryUser, int userFollowers) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.catagoryUser = catagoryUser;
        this.userFollowers = userFollowers;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public CatagoryUser getCatagoryUser() {
        return catagoryUser;
    }

    public void setCatagoryUser(CatagoryUser catagoryUser) {
        this.catagoryUser = catagoryUser;
    }

    public int getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(int userFollowers) {
        this.userFollowers = userFollowers;
    }
    
    
}
