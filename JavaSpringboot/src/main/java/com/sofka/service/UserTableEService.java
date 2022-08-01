package com.sofka.service;


import com.sofka.entity.UserTableE;
import com.sofka.repository.UserTableERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTableEService implements IUserTableEService {

    @Autowired
    private UserTableERepository userTableRepository;

    @Override
    public UserTableE saveTableUser(UserTableE userTable) {

        return userTableRepository.save(userTable);
    }

    @Override
    public UserTableE UserIdValidate(String id) {

        return userTableRepository.getUserTable(id);
    }
}





