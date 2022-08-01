package com.sofka.entity;
/**
 * import
 */

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


/**
 * Entity
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

@Getter
@Setter
@Entity
@Table(name = "current_game")
public class CurrentGame {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_game")
    private Integer idGame;
    private String letter;
    private int number;
}
