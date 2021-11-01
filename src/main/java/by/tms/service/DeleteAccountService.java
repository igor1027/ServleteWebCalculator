package by.tms.service;

import by.tms.repository.UserRepositoryFunction;

public class DeleteAccountService {

    public void deletedUser(int id){
        UserRepositoryFunction.deleteUser(id);
    }
}
