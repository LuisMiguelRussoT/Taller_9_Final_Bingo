package com.sofka.entity;

/**
 * imports
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

@Setter
@Getter
@Entity
public class User {

    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;
    private String usergameid;
    private boolean winner;

}
