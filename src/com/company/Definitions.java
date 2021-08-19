package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Definitions {

    Scanner scan = new Scanner(System.in);

    Dice dice = new Dice();
    TableDice tableDice = new TableDice();


    //test variable
    int numPlayers;

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
    private boolean callingLiar = false;

    //Operator for checking liar calling
    private int comparationValue;


    //Initiating the game
    public void start() {
        System.out.println("Welcome to Eri's liars dice game!");
        System.out.println("");
        System.out.println("How many players are playing?");
        numPlayers = Integer.parseInt(scan.nextLine());

        if(numPlayers < 2) {
            System.out.println("Invalid number of players, please select " +
                    "between 2-10.");
            start();
        }

        System.out.println("How many dices?");
        int die = Integer.parseInt(scan.nextLine());

            while (numPlayers > players.size()) {
                players.add(createNewPlayer());
            };

            while (isActive) {
                round();
            }

    }

    private Player createNewPlayer() {
        Player newPlayer = new Player();
        System.out.println("Whats the player name?");
        String name = scan.nextLine();
        name = newPlayer.name;
        return newPlayer;
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
                //tableDice.tableDices.add(player.diceValue);

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
                liarCheck();
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
        callingLiar = true;
        if(isLiar == true) {
            int countRepetition =
                    Collections.frequency(currentPlayer.diceValue, valueDicesBet);
            if(countRepetition == valueDicesBet) {
                System.out.println(currentPlayer + " is laying");
                dice.removeDie(currentPlayer);
            } else {
                System.out.println(currentPlayer.name + " is wrong");
                dice.removeDie(currentPlayer);
            }
            round();
        }
    }

    public void winningCondition() {

        for(Player player : players) {
            if(player.remainingDices == 0) {
                System.out.println(player.name + " looses!");
                isActive = false;
            }
        }
    }
}
