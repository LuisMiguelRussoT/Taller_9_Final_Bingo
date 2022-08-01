package com.sofka.service;

import com.sofka.dto.CurrentUserBallot;
import com.sofka.dto.PublicBoard;
import com.sofka.entity.CurrentUserBallotEntity;
import com.sofka.entity.User;

import java.util.List;

public interface IUserService {

    User save(User user);

    List<PublicBoard> publishBoard (Integer idGame);

    CurrentUserBallotEntity gamble(CurrentUserBallot currentUserBallot);
}
