package com.sofka.service;

/**
 * imports
 */

import com.sofka.entity.UserTableE;
import com.sofka.repository.UserTableERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTableEService implements IUserTableEService {

    @Autowired
    private UserTableERepository userTableRepository;


    /**
     * method to save user board
     *
     * @param userTable object represent a board
     * @return the board for a user
     */
    @Override
    public UserTableE saveTableUser(UserTableE userTable) {
        return userTableRepository.save(userTable);
    }

    /**
     * method to validate if the user have a board already assinged
     *
     * @param id user identification
     * @return check if user haver or not a board
     */

    @Override
    public UserTableE UserIdValidate(String id) {
        return userTableRepository.getUserTable(id);
    }
}





