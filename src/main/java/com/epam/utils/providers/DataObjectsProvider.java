package com.epam.utils.providers;

import com.epam.utils.Constants;

public class DataObjectsProvider implements Constants {
    public static Object[][] getUsers() {
        int usersAmount = TEST_USERS.size();
        Object[][] users = new Object[usersAmount][];
        for (int i = 0; i < usersAmount; i++) {
            users[i] = new Object[]{TEST_USERS.get(i).getEmail(), TEST_USERS.get(i).getPassword()};
        }
        return users;
    }
}
