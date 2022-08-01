package com.sofka.repository;

import com.sofka.dto.PublicBoard;
import com.sofka.entity.CurrentGame;
import com.sofka.entity.UserTableE;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CurrentGameRepository extends CrudRepository<CurrentGame, Integer> {

    @Query(value = "select letter,number from bingo.current_game where id_game = :id", nativeQuery = true)
    public List<String> publishBoard(@Param("id") Integer id);

    }
