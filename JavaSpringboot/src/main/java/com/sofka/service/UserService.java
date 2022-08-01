package com.sofka.service;
/**
 * imports
 */

import com.sofka.dto.CurrentUserBallot;
import com.sofka.dto.PublicBoard;
import com.sofka.entity.CurrentUserBallotEntity;
import com.sofka.entity.User;
import com.sofka.repository.CurrentGameRepository;
import com.sofka.repository.CurrentUserBallotRepository;
import com.sofka.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */
@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrentGameRepository currentGameRepository;

    @Autowired
    private CurrentUserBallotRepository currentUserBallotRepository;


    /**
     * method to save a user in db
     *
     * @param user user to save
     * @return save user
     */

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * method to publish the current board to all users
     *
     * @param idGame id current game
     * @return board current game
     */

    @Override
    public List<PublicBoard> publishBoard(Integer idGame) {
        List<PublicBoard> listPublicBoard = new ArrayList<>();
        List<String> listBallots = (currentGameRepository.publishBoard(idGame));
        for (String ballot : listBallots) {
            PublicBoard publicBoard = new PublicBoard();
            publicBoard.setLetter(ballot.split(",")[0]);
            publicBoard.setNumber(Integer.parseInt(ballot.split(",")[1]));
            listPublicBoard.add(publicBoard);
        }
        return listPublicBoard;
    }

    /**
     * method to save the current ballot on the game
     *
     * @param currentUserBallot current ballot
     * @return current ballot
     */

    @Override
    public CurrentUserBallotEntity gamble(CurrentUserBallot currentUserBallot) {
        var data = new CurrentUserBallotEntity();
        data.setNumber(currentUserBallot.getNumber());
        data.setLetter(currentUserBallot.getLetter());
        data.setUserId(currentUserBallot.getUser_id());
        data.setIdGame(currentUserBallot.getIdGame());
        var retorno = currentUserBallotRepository.save(data);

        return retorno;

    }


}
