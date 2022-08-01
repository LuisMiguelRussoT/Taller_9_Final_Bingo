package com.sofka.controller;
/**
 * Imports
 */

import com.sofka.dto.*;
import com.sofka.entity.*;
import com.sofka.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Main controller
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */


@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class BingoController {

    @Autowired
    private IBingoService bingoService;

    @Autowired
    private IAdminGame adminGame;

    @Autowired
    private UserService userService;


    /**
     * end point to generate board for each user in the game
     *
     * @param userId id of the user hoe get the board
     * @return a random generate board
     */

    @GetMapping(path = "/table/{userId}")
    public UserTable generateTable(@PathVariable String userId) {
        return bingoService.generateTable(userId);
    }

    /**
     * end point to pick a unique random ballot to all the users
     *
     * @param idGame id of the game that will have all ballots
     * @return a random generate ballot
     */

    @GetMapping(path = "/ballot/{idGame}")
    public List<PublicBoard> getBallot(@PathVariable Integer idGame) {
        bingoService.pickUpBallot(idGame);

        List<PublicBoard> publicBoard = userService.publishBoard(idGame);
        return publicBoard;
    }

    /**
     * end point to publish the ballots to all the users in the game at the same time
     *
     * @param idGame id current game
     * @return board to publish all the boards on the game
     */

    @GetMapping(path = "/allballot/{idGame}")
    public List<PublicBoard> getAllBallot(@PathVariable Integer idGame) {

        List<PublicBoard> publicBoard = userService.publishBoard(idGame);
        return publicBoard;
    }

    /**
     * end point to verify if there is any game active
     *
     * @return result if any game is active
     */

    @GetMapping(path = "/game-active")
    public ActiveResponse gameStatus() {
        var data = adminGame.gameActive();
        return data;
    }

    /**
     * end point to get the winner of the game
     *
     * @return if there is a winner in the current game
     */
    @GetMapping(path = "/get-winner-game")
    public Game getWinnerGame() {
        return adminGame.ValidateWinnerInCurrentGame();
    }

    /**
     * end point to create a new game in the DB
     *
     * @return a new game
     */
    @PostMapping(path = "/create-game")
    public Game saveNewGame() {
        Game games = new Game();
        games.setStatus(true);
        var data = adminGame.createGame(games);
        return data;
    }

    /**
     * end point to create a new user geting info form nodejs
     *
     * @param usergameid user id asing to the user by nodejs in mongoBD
     * @return
     */

    @PostMapping(path = "/create-user/{usergameid}")
    public User saveNewUser(@PathVariable String usergameid) {
        User user = new User();
        user.setUsergameid(usergameid);
        user.setWinner(false);
        var data = userService.save(user);
        return data;
    }

    /**
     * end point to save al the ballots that the user mark on his borad
     *
     * @param gamble object that content all the user played ballots
     * @return all ballots mark on player's board
     */

    @PostMapping(path = "/playgame")
    public CurrentUserBallotEntity gamble(@RequestBody CurrentUserBallot gamble) {
        return userService.gamble(gamble);
    }

    /**
     * endpoint to save winner
     *
     * @param idwinner id of the user that win this play
     */
    @PostMapping(path = "/setwinner")
    public void setWinner(@RequestBody String idwinner) {
        adminGame.setWinner(idwinner);

    }


}








