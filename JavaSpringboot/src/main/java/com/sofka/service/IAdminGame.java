package com.sofka.service;

/**
 * imports
 */

import com.sofka.dto.ActiveResponse;
import com.sofka.entity.Game;

/**
 * interface
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

public interface IAdminGame {

    ActiveResponse gameActive();

    Game createGame(Game games);

    void setWinner (String idWinner);

    Game ValidateWinnerInCurrentGame ();
}
