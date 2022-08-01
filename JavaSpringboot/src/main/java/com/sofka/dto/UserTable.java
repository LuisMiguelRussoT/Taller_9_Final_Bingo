package com.sofka.dto;

/***
 * imports
 */

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Dto
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

@Getter
@Setter
public class UserTable {

    private List<Letter> letters;
}
