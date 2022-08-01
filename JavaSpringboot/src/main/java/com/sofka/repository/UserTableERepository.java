package com.sofka.repository;

/**
 * imports
 */

import com.sofka.entity.UserTableE;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

@Repository
public interface UserTableERepository extends CrudRepository<UserTableE,Integer> {

    /**
     * query to get the current board for a user
     * @param id user identification
     * @return current board for user
     */
    @Query(value = "select * from user_table where user_id = :id limit 1", nativeQuery = true)
    public UserTableE getUserTable(@Param("id") String id);

}
