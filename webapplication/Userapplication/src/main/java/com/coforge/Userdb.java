package com.coforge;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Collection;

public class Userdb {
    // username -> User object
    public static final Map<String, User> USERS = new ConcurrentHashMap<>();

    static {
        // Demo users
        USERS.put("admin", new User("admin", "Admin User", "admin@example.com", "admin123"));
        USERS.put("john", new User("john", "John Doe", "john@example.com", "john123"));
        USERS.put("jane", new User("jane", "Jane Smith", "jane@example.com", "jane123"));
    }

    private Userdb() {}

    // Create - Add a new user
    public static boolean addUser(String username, String fullName, String email, String password) {
        if (USERS.containsKey(username)) {
            return false; // User already exists
        }
        User user = new User(username, fullName, email, password);
        USERS.put(username, user);
        return true;
    }

    // Read - Get all users
    public static Collection<User> getAllUsers() {
        return USERS.values();
    }

    // Read - Get a specific user
    public static User getUserByUsername(String username) {
        return USERS.get(username);
    }

    // Update - Update user information
    public static boolean updateUser(String username, String fullName, String email, String password) {
        if (!USERS.containsKey(username)) {
            return false; // User doesn't exist
        }
        User user = USERS.get(username);
        user.setFullName(fullName);
        user.setEmail(email);
        if (password != null && !password.isEmpty()) {
            user.setPassword(password);
        }
        return true;
    }

    // Delete - Remove a user
    public static boolean deleteUser(String username) {
        return USERS.remove(username) != null;
    }

    // Check if user exists
    public static boolean userExists(String username) {
        return USERS.containsKey(username);
    }

    // Authenticate user
    public static boolean authenticate(String username, String password) {
        User user = USERS.get(username);
        return user != null && user.getPassword().equals(password);
    }
}