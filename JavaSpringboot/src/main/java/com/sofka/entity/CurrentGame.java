package com.sofka.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
