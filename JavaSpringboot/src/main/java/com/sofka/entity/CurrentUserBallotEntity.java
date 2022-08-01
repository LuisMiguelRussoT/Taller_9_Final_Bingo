package com.sofka.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity // Lo hace como una tabla
@Table(name = "current_user_ballot") // asignar nombre de la tabla para identificarla
public class CurrentUserBallotEntity {

    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "id_game")
    private Integer idGame;
    private String letter;
    private Integer number;
}
