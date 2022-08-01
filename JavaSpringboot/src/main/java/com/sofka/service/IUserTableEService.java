package com.sofka.service;

/**
 * imports
 */

import com.sofka.entity.UserTableE;

/**
 * interface
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

public interface IUserTableEService {

    public UserTableE saveTableUser(UserTableE userTable);

    public UserTableE UserIdValidate (String id);

    }
