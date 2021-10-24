package by.tms.storage;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private final static List<User> userList = new ArrayList<>();

    public static void addUser(User user){
        userList.add(user);
    }

    public User findByUsername(String username){
        for(User user : userList){
            if (user.getUsername().equals(username)){
                return  user;
            }
        }
        return null;
    }
}
