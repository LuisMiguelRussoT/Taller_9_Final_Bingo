package com.sofka.service;

import com.sofka.dto.ActiveResponse;
import com.sofka.dto.PublicBoard;
import com.sofka.entity.Game;
import com.sofka.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminGame implements IAdminGame {

    @Autowired
    GameRepository gameRepository;

    @Override
    public ActiveResponse gameActive() {

        ActiveResponse activeResponse = new ActiveResponse();
      var games = gameRepository.getGameActive();

      if(games.isPresent()){
          activeResponse.setActive(true);
          activeResponse.setIdGame(games.get().getIdGame().toString());
      }

      return activeResponse;
    }

    @Override
    public Game createGame(Game games) {
        return  gameRepository.save(games);
    }

    @Override
    public void setWinner( String idwinner) {
         gameRepository.setWinner(idwinner);
    }

    @Override
    public Game ValidateWinnerInCurrentGame() {
         return gameRepository.ValidateWinnerInCurrentGame();
    }


}
