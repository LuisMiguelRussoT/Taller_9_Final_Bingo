package com.sofka.service;

/**
 * imports
 */

import com.sofka.dto.ActiveResponse;
import com.sofka.entity.Game;
import com.sofka.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

@Slf4j
@Service
public class AdminGame implements IAdminGame {

    @Autowired
    GameRepository gameRepository;


    /**
     * method to verify is there is any active case in there is no active game create one
     *
     * @return result is there is an active game
     */
    @Override
    public ActiveResponse gameActive() {
        ActiveResponse activeResponse = new ActiveResponse();
        var games = gameRepository.getGameActive();

        if (games.isPresent()) {
            activeResponse.setActive(true);
            activeResponse.setIdGame(games.get().getIdGame().toString());
        }
        return activeResponse;
    }

    /**
     * method to create a game on db
     * @param games object tahat represent a game
     * @return save on db a new game
     */
    @Override
    public Game createGame(Game games) {
        return gameRepository.save(games);
    }

    /**
     * method to set a new a winner for the current game
     * @param idwinner user identification
     */

    @Override
    public void setWinner(String idwinner) {
        gameRepository.setWinner(idwinner);
    }

    /**
     * method to valid is the current game already have a winner
     * @return if there is or not a winner on the game
     */

    @Override
    public Game ValidateWinnerInCurrentGame() {
        return gameRepository.ValidateWinnerInCurrentGame();
    }


}
