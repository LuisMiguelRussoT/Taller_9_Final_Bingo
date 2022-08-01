package com.sofka.dto;

/**
 * imports
 */

import com.sofka.enums.LetterType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class Letter {

    private LetterType letter;
    private List<String> numbers;
}
