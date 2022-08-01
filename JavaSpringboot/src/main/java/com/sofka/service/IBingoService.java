package com.sofka.service;

import com.sofka.dto.MainBoard;
import com.sofka.dto.UserTable;

/**
 * Interface of services
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/07/20
 * @since 1.0.0
 */

public interface IBingoService {

     UserTable generateTable(String userId);

     MainBoard pickUpBallot (Integer idGame);
}
