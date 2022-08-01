package com.sofka.dto;
/**
 * imports
 */

import com.sofka.enums.LetterType;
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
public class MainBoard {

    private LetterType letter;
    private int number;

}
