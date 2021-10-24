package by.tms.service;

import by.tms.entity.User;
import by.tms.repository.UserRepositoryCheck;
import by.tms.repository.UserRepositoryFunction;

public class AuthorizacionServiceImp {

    public boolean checkUsername(String username){
        return UserRepositoryCheck.checkForExistenceName(username);
    }

    public boolean chechkPassword(String username, String password){
        return UserRepositoryCheck.checkPassword(username, password);
    }

    public User gettingUser(String username){
        return UserRepositoryFunction.getUser(username);
    }

}
