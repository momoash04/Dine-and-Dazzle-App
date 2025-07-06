package com.example.adv_software_project;
public class UserSession {
    private static UserSession instance;
    private User loggedInUser;

    // Private constructor to prevent instantiation
    private UserSession() {}

    // Method to get the singleton instance
    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    // Method to set the logged-in user
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    // Method to get the logged-in user
    public User getLoggedInUser() {
        return loggedInUser;
    }

    // Check if a user is logged in
    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    // Clear the logged-in user (e.g., on logout)
    public void logout() {
        loggedInUser = null;
    }
}