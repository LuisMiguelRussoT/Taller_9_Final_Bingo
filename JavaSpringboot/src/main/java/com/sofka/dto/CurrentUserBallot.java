package com.sofka.dto;
/**
 * Imports
 */

import lombok.Getter;
import lombok.Setter;
/**
 * Dto
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */


@Getter
@Setter

public class CurrentUserBallot {

    private Integer id;
    private String user_id;
    private Integer idGame;
    private String letter;
    private Integer number;
}
