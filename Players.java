import java.util.Random;
import java.util.Scanner;

public class Players {

    public void numPlayers (String[] args) {

    }
        Scanner scan = new Scanner(System.in);

        Random randomNum = new Random();

        System.out.println("Welcome to Eri's Liar Dice Game!");
        System.out.println("How many players would like to play?");

        int numPlayers = scan.nextInt(); //Getting number of players that are playing

        switch numPlayers {
            case 2:
                private int user1NumDiceRemaining = 5;
                private int user2NumDiceRemaining = 5;
                break;
        case 3:
            private int user1NumDiceRemaining = 5;
            private int user2NumDiceRemaining = 5;
            private int user3NumDiceRemaining = 5;
            break;
        };

        private String[] numberGuess = new String[] {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
                "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE"};



}
