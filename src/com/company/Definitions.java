package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Definitions {

    Scanner scan = new Scanner(System.in);

    Dice dice = new Dice();
    TableDice tableDice = new TableDice();


    public Player currentPlayer;

    //Initializing players array
    public ArrayList<Player> players = new ArrayList<>();


    //Initializing values used for bet
    private int currentDiceNumberBet = 0;
    private int numberDicesBet;
    private int valueDicesBet;

    //Initialize round counter
    private int round;

    //Checker if game is still on
    private boolean isActive = true;

    //Checker for calling liar
    private boolean isLiar = false;

    //Operator for checking liar calling
    private int comparationValue;


    //Initiating the game
    public Definitions() {
        System.out.println("Welcome to Eri's liars dice game!");
        System.out.println("");
        System.out.println("How many players are playing?");
        int numPlayers = scan.nextInt();
        System.out.println("How many dices?");
        int die = scan.nextInt();

        while (numPlayers > players.size()) {
            String name = newPlayer();
            players.add(new Player(name, die));
            System.out.println(players.size());
        };

        while(isActive) {
            round();
        }

    }

    private String newPlayer() {
        System.out.println("Whats the player name?");
        String ts = scan.nextLine();
        String name = scan.nextLine();
        return name;
    }

    //Game round method
    public void round() {
        for(Player player : players) {
            currentPlayer = player;
            if(player.remainingDices == 0) {
                System.out.println("Game Over! " + player.name + " Wins! Number of rounds: " + round);
                isActive = false;
            } else if (player.remainingDices == 0) {
                System.out.println("Game Over! " + player.name + " Wins! Number of rounds: " + round);
                isActive = false;
            } else {
                //Round counter
                round += 1;

                System.out.println("It's " + player.name + " turn, " + "next player please look away.");
                dice.rollDice(player);
                tableDice.tableDices.add(player.diceValue);
                //Betting system
                bet();
                System.out.println("\n\n\n");
            }
        }
    }

    //Betting method
    public void bet() {
        if(currentDiceNumberBet == 0) {
            System.out.println("What's the number of dices you are betting?");
            numberDicesBet = scan.nextInt();
            numberDicesBet = currentDiceNumberBet;
            System.out.println("What's the value of the dices you are betting?");
            valueDicesBet = scan.nextInt();
        } else if(numberDicesBet < currentDiceNumberBet) {
            System.out.println("Previous player bet there's " + currentDiceNumberBet + " numbers " + valueDicesBet +
                    ", call layer (type 0)");
            numberDicesBet = scan.nextInt();
            if(numberDicesBet == 0) {
                //liarCheck();
            } else {
                currentDiceNumberBet = numberDicesBet;
                System.out.println("What's the value of the dices you are betting?");
                valueDicesBet = scan.nextInt();
            }
        } else {
            System.out.println("Invalid bet, try again");
            bet();
        }
    }

    public void liarCheck() {
        if(isLiar == true) {
            int countRepetition =
                    Collections.frequency(player.diceValue, valueDicesBet);
            if(countRepetition == valueDicesBet) {
                System.out.println(currentPlayer + " is laying");
                dice.removeDie(currentPlayer);
            } else {
                System.out.println(player1.name + " is wrong");
                dice.removeDie(currentPlayer);
            }
        }



    }
}
