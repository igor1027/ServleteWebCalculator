package by.tms.service;

import by.tms.repository.UserRepositoryFunction;

public class ChangeService {

    public void passwordChange(int id, String changePassword){
        UserRepositoryFunction.changePassword(id, changePassword);
    }

    public void nameChange(int id, String changeName){
        UserRepositoryFunction.changeName(id, changeName);
    }
}
