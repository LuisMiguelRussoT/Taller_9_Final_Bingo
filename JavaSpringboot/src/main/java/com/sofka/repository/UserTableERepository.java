package com.sofka.repository;

import com.sofka.entity.UserTableE;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTableERepository extends CrudRepository<UserTableE,Integer> {


    @Query(value = "select * from user_table where user_id = :id limit 1", nativeQuery = true)
    public UserTableE getUserTable(@Param("id") String id);

}
