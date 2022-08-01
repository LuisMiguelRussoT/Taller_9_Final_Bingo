package com.sofka.service;

/**
 * import
 */

import com.sofka.dto.Letter;
import com.sofka.dto.MainBoard;
import com.sofka.dto.PublicBoard;
import com.sofka.dto.UserTable;
import com.sofka.entity.CurrentGame;
import com.sofka.entity.UserTableE;
import com.sofka.enums.LetterType;
import com.sofka.repository.CurrentGameRepository;
import com.sofka.repository.UserTableERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/07/20
 * @since 1.0.0
 */

@Service
public class BingoService implements IBingoService {
    Random random = new Random();
    @Autowired
    private CurrentGameRepository currentGameRep;
    @Autowired
    private UserTableERepository userTableERepository;
    @Autowired
    private IUserService userService;


    /**
     * method to pickup a unique random ballot for the current game
     *
     * @param idGame id current game
     * @return unique random ballot
     */

    public MainBoard pickUpBallot(Integer idGame) {
        MainBoard mainBoard = new MainBoard();
        boolean duplicateValueRun = true;
        boolean duplicateValue;
        List<PublicBoard> listBallots = userService.publishBoard(idGame);
        if (listBallots.size() <= 75) {
            while (duplicateValueRun) {
                int count = randomNumber(1, 6);
                duplicateValue = false;
                mainBoard = this.generateBallotValue(count);
                for (PublicBoard ballot : listBallots) {
                    if (ballot.getNumber() == mainBoard.getNumber()) {
                        duplicateValue = true;
                    }
                }
                if (!duplicateValue) duplicateValueRun = false;
            }
            CurrentGame currentGame = new CurrentGame();
            currentGame.setLetter(mainBoard.getLetter().getLetter());
            currentGame.setNumber(mainBoard.getNumber());
            currentGame.setIdGame(idGame);
            this.currentGameRep.save(currentGame);
        }
        return mainBoard;
    }


    /**
     * method to generate value of a ballot number and letter
     *
     * @param count random number to generate a ballot with letter B,I,N,G,O
     * @return value for the ballot
     */

    private MainBoard generateBallotValue(int count) {
        MainBoard mainBoard = new MainBoard();
        switch (count) {
            case 1:
                mainBoard.setLetter(LetterType.B);
                mainBoard.setNumber(this.randomNumber(LetterType.B.getMin(), LetterType.B.getMax()));
                break;
            case 2:
                mainBoard.setLetter(LetterType.I);
                mainBoard.setNumber(this.randomNumber(LetterType.I.getMin(), LetterType.I.getMax()));
                break;
            case 3:
                mainBoard.setLetter(LetterType.N);
                mainBoard.setNumber(this.randomNumber(LetterType.N.getMin(), LetterType.N.getMax()));
                break;
            case 4:
                mainBoard.setLetter(LetterType.G);
                mainBoard.setNumber(this.randomNumber(LetterType.G.getMin(), LetterType.G.getMax()));
                break;
            case 5:
                mainBoard.setLetter(LetterType.O);
                mainBoard.setNumber(this.randomNumber(LetterType.O.getMin(), LetterType.O.getMax()));
                break;
        }
        return mainBoard;
    }

    /**
     * method to control each ballot is unique and random for user board
     *
     * @param userId current user
     * @return board for the user
     */

    @Override
    public UserTable generateTable(String userId) {

        UserTable usertable = new UserTable();
        UserTableE userTableE = this.userTableERepository.getUserTable(userId);
        if (userTableE == null) {
            Letter b = this.generateLetter(LetterType.B);
            Letter i = this.generateLetter(LetterType.I);
            Letter n = this.generateLetter(LetterType.N);
            Letter g = this.generateLetter(LetterType.G);
            Letter o = this.generateLetter(LetterType.O);
            usertable.setLetters(List.of(b, i, n, g, o));
            UserTableE nUserT = new UserTableE();
            nUserT.setUserid(userId);
            nUserT.setB(this.mapNumbersToString(b.getNumbers()));
            nUserT.setI(this.mapNumbersToString(i.getNumbers()));
            nUserT.setN(this.mapNumbersToString(n.getNumbers()));
            nUserT.setG(this.mapNumbersToString(g.getNumbers()));
            nUserT.setO(this.mapNumbersToString(o.getNumbers()));
            this.userTableERepository.save(nUserT);

        } else {
            Letter b = new Letter();
            b.setLetter(LetterType.B);
            List<String> numbersB = Arrays.asList(userTableE.getB().split(","));
            b.setNumbers(numbersB);

            Letter i = new Letter();
            i.setLetter(LetterType.I);
            List<String> numbersI = Arrays.asList(userTableE.getI().split(","));
            i.setNumbers(numbersI);

            Letter n = new Letter();
            n.setLetter(LetterType.N);
            List<String> numbersN = Arrays.asList(userTableE.getN().split(","));
            n.setNumbers(numbersN);

            Letter g = new Letter();
            g.setLetter(LetterType.G);
            List<String> numbersG = Arrays.asList(userTableE.getG().split(","));
            g.setNumbers(numbersG);

            Letter o = new Letter();
            o.setLetter(LetterType.O);
            List<String> numbersO = Arrays.asList(userTableE.getO().split(","));
            o.setNumbers(numbersO);

            usertable.setLetters(List.of(b, i, n, g, o));
        }
        return usertable;
    }

    /**
     * method to generate each letter in his asingned value
     *
     * @param letterType a enum that asing letter, min and max for each letter of bingo
     * @return
     */

    private Letter generateLetter(LetterType letterType) {
        Letter l = new Letter();
        switch (letterType) {
            case B -> {
                l.setLetter(LetterType.B);
                l.setNumbers(this.getNumbers(LetterType.B.getMin(), LetterType.B.getMax()));
            }
            case I -> {
                l.setLetter(LetterType.I);
                l.setNumbers(this.getNumbers(LetterType.I.getMin(), LetterType.I.getMax()));
            }
            case N -> {
                l.setLetter(LetterType.N);
                l.setNumbers(this.getNumbers(LetterType.N.getMin(), LetterType.N.getMax()));
            }
            case G -> {
                l.setLetter(LetterType.G);
                l.setNumbers(this.getNumbers(LetterType.G.getMin(), LetterType.G.getMax()));
            }
            case O -> {
                l.setLetter(LetterType.O);
                l.setNumbers(this.getNumbers(LetterType.O.getMin(), LetterType.O.getMax()));
            }
        }
        return l;
    }

    /**
     * method to avoid that numbers on user board be duplciate
     *
     * @param min min value for each letter of bingo
     * @param max max value for each letter of bingo
     * @return unique number
     */

    private List<String> getNumbers(int min, int max) {
        List<String> numbersUser = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            String temp = String.valueOf(this.randomNumber(min, max));
            while (numbersUser.contains(temp)) {
                temp = String.valueOf(this.randomNumber(min, max));
            }
            numbersUser.add(temp);
        }
        return numbersUser;
    }

    /**
     * method to generate randon number
     *
     * @param min min amount
     * @param max max amount
     * @return a randon number
     */

    private int randomNumber(int min, int max) {
        return this.random.nextInt(min, max);
    }

    /**
     * method to map number form db to separate elements
     *
     * @param numbers a Integer
     * @return separete numbers
     */
    private String mapNumbersToString(List<String> numbers) {
        return numbers.stream().map(n -> n).collect(Collectors.joining(","));
    }
}
