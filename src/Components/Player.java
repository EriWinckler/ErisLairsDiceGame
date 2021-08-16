package Components;

import java.util.Random;
import java.util.Scanner;

public class Player {

    public Player() {



        Random randomNum = new Random();

        System.out.println("Welcome to Eri's Liar Dice Game!");
        System.out.println("How many players would like to play?");


        int numPlayers = scan.nextInt(); //Getting number of players that are playing


        /*
        switch (numPlayers) {
            case 2:
                int user1NumDiceRemaining = 5;
                int user2NumDiceRemaining = 5;
                break;

            case 3:
                int user1NumDiceRemaining = 5;
                int user2NumDiceRemaining = 5;
                int user3NumDiceRemaining = 5;
                break;

            case 4:
                int user1NumDiceRemaining = 5;
                int user2NumDiceRemaining = 5;
                int user3NumDiceRemaining = 5;
                int user4NumDiceRemaining = 5;
                break;

            case 5:
                int user1NumDiceRemaining = 5;
                int user2NumDiceRemaining = 5;
                int user3NumDiceRemaining = 5;
                int user4NumDiceRemaining = 5;
                int user5NumDiceRemaining = 5;
                break;

            case 6:
                int user1NumDiceRemaining = 5;
                int user2NumDiceRemaining = 5;
                int user3NumDiceRemaining = 5;
                int user4NumDiceRemaining = 5;
                int user5NumDiceRemaining = 5;
                int user6NumDiceRemaining = 5;
                break;
            default:
                throw new IllegalStateException("Value of: " + numPlayers + " Not acceptable, please choose between 1 and 6");
        };
        */
        private String[] numberGuess = new String[] {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
                "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE"};


    }
}
