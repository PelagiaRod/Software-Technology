package gr.aueb.sweng22.team07;

import java.io.Serializable;
import java.util.ArrayList;

public class Authentication {

    static ArrayList<User> allUsers;
    private User userInDatabase;

    // Sign Up
    public boolean signUp(User userToSearch) {
        if (this.allUsersEmpty()) {
            allUsers = new ArrayList<>();
            allUsers.add(userToSearch);
            return true;
        } else {
            if (validateUsername(userToSearch)) {
                return false;
            } else {
                allUsers.add(userToSearch);
                return true;
            }
        }
    }

    // Log In
    public User logIn(User userToSearch) {
        if (validateUsername(userToSearch)) {
            if ( validatePassword(userToSearch)) {
                return userInDatabase;
            }
        }
        return null;
    }

    // check if allUsers is empty
    private boolean allUsersEmpty() {
        return allUsers == null;
    }

    /// VALIDATIONS
    // search given user
    private boolean validateUsername(User userToSearch) {
        for (User user: allUsers){
            if (userToSearch.getUsername().equals(user.getUsername())) {
                userInDatabase = user;
                return true;
            }
        }
        return false;
    }

    // check if password is valid
    private boolean validatePassword(User userToSearch) {
        return userToSearch.getPassword() == userInDatabase.getPassword();
    }


    // getters
    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

}
