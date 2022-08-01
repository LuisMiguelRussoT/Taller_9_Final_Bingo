package com.sofka.enums;

/**
 * imports
 */

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

@RequiredArgsConstructor
@Getter()
public enum LetterType {

    B("B", 1, 16),
    I("I", 16, 31),
    N("N", 31, 46),
    G("G", 46, 61),
    O("O", 61, 76);
    private String letter;
    private int min;
    private int max;

    LetterType(String letter, int min, int max) {
        this.letter = letter;
        this.min = min;
        this.max = max;
    }
}
