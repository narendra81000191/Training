package com.coforge;



import java.util.HashSet;
import java.util.Set;

/** Whitelist of usernames allowed to login (case-insensitive). */
public class AllowedUsernames {
    private static final Set<String> ALLOWED = new HashSet<>();

    static {
        // ✅ Add allowed usernames here
        ALLOWED.add("nikku");
        ALLOWED.add("rahul");
        ALLOWED.add("pooja");
        ALLOWED.add("anjali");
        // add more as needed…
    }

    public static boolean isAllowed(String username) {
        return username != null && ALLOWED.contains(username.toLowerCase());
    }
}