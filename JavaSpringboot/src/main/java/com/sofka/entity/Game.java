package com.sofka.entity;

/**
 * imports
 */

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

/**
 * Entity
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

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
