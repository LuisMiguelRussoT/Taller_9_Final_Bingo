package com.sofka.repository;

/**
 * imports
 */

import com.sofka.entity.Game;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


/**
 * Repository
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

public interface GameRepository extends CrudRepository<Game,Integer> {

    /**
     * querry to select if there is any game active at the moment
     * @return if there is an active game
     */
    @Query(value = "select * from Games  where status = 1 limit 1",nativeQuery = true)
    public Optional<Game> getGameActive(
    );


    /**
     * query update a game that is finish
     * @param idwinner id of the winner
     */

    @Transactional
    @Modifying
    @Query(value = "update Games set idwinner = :idwinner, status = 0 where status = 1",nativeQuery = true)
    public void setWinner(@Param("idwinner") String idwinner);


    /**
     * querry to get the last game on the Db
     * @return last game on db
     */
    @Query(value = "select * from Games order by date desc limit 1 ",nativeQuery = true)
    public Game ValidateWinnerInCurrentGame();

}
