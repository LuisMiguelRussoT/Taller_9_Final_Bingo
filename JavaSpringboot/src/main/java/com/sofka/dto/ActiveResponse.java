package com.sofka.dto;
/**
 * Imports
 */

import lombok.Getter;
import lombok.Setter;

/**
 * Dto active response
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

@Getter
@Setter
public class ActiveResponse {

    private boolean isActive;
    private String idGame;
    private String idwinner;
}
