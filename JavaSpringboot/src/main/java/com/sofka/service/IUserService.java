package com.sofka.service;
/**
 * imports
 */

import com.sofka.dto.CurrentUserBallot;
import com.sofka.dto.PublicBoard;
import com.sofka.entity.CurrentUserBallotEntity;
import com.sofka.entity.User;
import java.util.List;

/**
 * interface
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

public interface IUserService {

    User save(User user);

    List<PublicBoard> publishBoard (Integer idGame);

    CurrentUserBallotEntity gamble(CurrentUserBallot currentUserBallot);
}
