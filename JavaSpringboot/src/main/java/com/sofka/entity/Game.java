package com.sofka.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity()
@Table(name = "games")
public class Game {

    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgame")
    private Integer idGame;
    @CreationTimestamp
    private Date date;
    private Boolean status;
    private String idwinner;

}
