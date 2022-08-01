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
@Table(name = "user_table")
public class UserTableE {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userid;
    private String b,i,n,g,o;

}
