/*
Steps we need to create the game:
    1 - Set the number of players and the correspondent variables.
    2 - Populate the dice arrays with Random dices in the 1 - 6 range.
    3 - Ask if player want to challenge.
        3.1 - If challenge, request number dices and value is the guess.
    4 - Ask next player for a challenge.
    5 - If players decide to challenge, update values of dices and guesses.
    6 - If player decide not to challenge, check all the dices on the table and compare with number of dices and
    values guessed.
    7 -
    7 - Check if there's still more than one player with dices.
 */

import java.util.*;

public class main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Eri's Liar Dice Game!");
        System.out.println("How many players would like to play?");


        int numPlayers = scan.nextInt(); //Getting number of players that are playing

    }


}
