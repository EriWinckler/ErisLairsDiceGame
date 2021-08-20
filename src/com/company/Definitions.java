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
    int playerCount;
    boolean secondTurn = false;

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
                players.add(createNewPlayer(die));
            };

            while (isActive) {
                round();
            }
    }

    private Player createNewPlayer(int die) {
        Player newPlayer = new Player();
        System.out.println("Whats the player name?");
        String name = scan.nextLine();
        newPlayer.name = name;
        newPlayer.remainingDices = die;
        return newPlayer;
    }

    //Game round method
    public void round() {

        for(int i = 0; i < players.size(); i++) {
            currentPlayer = players.get(i);

            if (currentPlayer.remainingDices == 0) {
                System.out.println("Game Over for " + currentPlayer.name +
                        " " +
                        "Number of rounds: " + round);
                currentPlayer.active = false;
            } else {
                //Round counter
                round += 1;

                System.out.println("It's " + currentPlayer.name + " turn, " +
                        "next player please look away.");
                if(secondTurn == false) {
                    dice.rollDice(currentPlayer);
                } else {
                    bet();
                }
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
            currentDiceNumberBet = numberDicesBet;
            System.out.println("What's the value of the dices you are betting?");
            valueDicesBet = scan.nextInt();
        } else if(numberDicesBet < currentDiceNumberBet) {
            System.out.println("Previous player bet there's " + currentDiceNumberBet + " numbers " + valueDicesBet +
                    ", call layer (type 0), continue type 1");
            secondTurn = true;
            int secondBet = scan.nextInt();
            switch (secondBet){
                case 0:
                    liarCheck();
                default:
                    System.out.println("What's the number of dices you are betting?");
                    numberDicesBet = scan.nextInt();
                    currentDiceNumberBet = numberDicesBet;
                    System.out.println("What's the value of the dices you are betting?");
                    valueDicesBet = scan.nextInt();
            }
        } else {
            System.out.println("Invalid bet, try again");
            numberDicesBet = 0;
            bet();
        }
    }

    public void liarCheck() {
        callingLiar = true;
        if(callingLiar == true) {
            int countRepetition =
                    Collections.frequency(currentPlayer.diceValue, valueDicesBet);
            if(countRepetition == valueDicesBet) {
                System.out.println(currentPlayer + " is laying");
                dice.removeDie(currentPlayer);
            } else {
                System.out.println(currentPlayer.name + " is wrong");
                dice.removeDie(currentPlayer);
                round();
            }
            for(int i = 0; i < players.size(); i++) {
                playerCount++;
                i++;
            }
            if (playerCount == 1) {
                System.out.println("Game Over " + currentPlayer.name + " Wins" +
                        "!");
            } else {
                round();
            }
        }
    }
}
