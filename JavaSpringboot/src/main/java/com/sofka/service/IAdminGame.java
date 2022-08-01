package com.sofka.service;

import com.sofka.dto.ActiveResponse;
import com.sofka.dto.PublicBoard;
import com.sofka.entity.Game;

public interface IAdminGame {
    ActiveResponse gameActive();

    Game createGame(Game games);

    void setWinner (String idWinner);

    Game ValidateWinnerInCurrentGame ();
}
