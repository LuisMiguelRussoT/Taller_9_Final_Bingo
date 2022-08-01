package com.sofka.repository;

/**
 * imports
 */

import com.sofka.entity.CurrentGame;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Repository
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

public interface CurrentGameRepository extends CrudRepository<CurrentGame, Integer> {

    /**
     * Querry to search for ballots played on the game
     * @param id id for the current game
     * @return all ballots playes in this game
     */

    @Query(value = "select letter,number from bingo.current_game where id_game = :id", nativeQuery = true)
    public List<String> publishBoard(@Param("id") Integer id);

    }
