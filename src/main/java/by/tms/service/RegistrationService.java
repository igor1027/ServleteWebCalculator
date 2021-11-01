package by.tms.service;

import by.tms.entity.User;
import by.tms.repository.UserRepositoryCheck;
import by.tms.repository.UserRepositoryFunction;

public class RegistrationService {

    public static void createUser(String name, String username, String password){
        User user = new User(name,username,password);
        UserRepositoryFunction.saveUser(user);
    }
    public boolean checkUsername(String username){
        return !UserRepositoryCheck.checkForExistenceName(username);
    }
}
