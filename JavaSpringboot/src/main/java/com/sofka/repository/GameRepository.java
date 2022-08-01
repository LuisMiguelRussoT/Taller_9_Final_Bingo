package com.sofka.repository;

import com.sofka.dto.PublicBoard;
import com.sofka.entity.Game;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game,Integer> {


    @Query(value = "select * from Games  where status = 1 limit 1",nativeQuery = true)
    public Optional<Game> getGameActive(
    );

    @Transactional
    @Modifying
    @Query(value = "update Games set idwinner = :idwinner, status = 0 where status = 1",nativeQuery = true)
    public void setWinner(@Param("idwinner") String idwinner);

    @Query(value = "select * from Games order by date desc limit 1 ",nativeQuery = true)
    public Game ValidateWinnerInCurrentGame();






}
