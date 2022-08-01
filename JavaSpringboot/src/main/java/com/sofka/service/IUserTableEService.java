package com.sofka.service;


import com.sofka.entity.UserTableE;

public interface IUserTableEService {

    public UserTableE saveTableUser(UserTableE userTable);

    public UserTableE UserIdValidate (String id);

    }
