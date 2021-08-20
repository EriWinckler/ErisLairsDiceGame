package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Definitions {

    Scanner scan = new Scanner(System.in);

    Dice dice = new Dice();
    TableDice tableDice = new TableDice();
    public ArrayList<Integer> finalList = new ArrayList<>();


    //test variable
    int numPlayers;
    int playerCount;
    boolean secondTurn = false;
    int currentDiceValueBet;

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
        dice.rollDice(newPlayer);
        playerCount++;
        return newPlayer;
    }

    //Game round method
    public void round() {
        //Round counter
        checkGameState();
            round += 1;

            for(int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);

                if (currentPlayer.remainingDices == 0) {
                    System.out.println("Game Over for " + currentPlayer.name + "Number of rounds: " + round);
                    currentPlayer.active = false;
                } else {
                System.out.println("It's " + currentPlayer.name + " turn, " + "other players please look away.");
                Player.handCheck(currentPlayer);

                if(secondTurn == true) {
                    dice.rollDice(currentPlayer);
                    tableDice.addAll(currentPlayer.diceValue);
                }
                checkGameState();
                if(!isActive) {
                    break;
                }

                //Betting method
                bet();
                System.out.println("\n\n\n");
                }
            }

    }

    //Betting method
    public void bet() {
        boolean validBet = numberDicesBet <= currentDiceNumberBet || valueDicesBet != currentDiceValueBet;

            if (currentDiceNumberBet == 0) {
                System.out.println("What's the number of dices you are betting?");
                numberDicesBet = scan.nextInt();
                currentDiceNumberBet = numberDicesBet;
                System.out.println("What's the value of the dices you are betting?");
                valueDicesBet = scan.nextInt();
                currentDiceValueBet = valueDicesBet;
            } else if (validBet) {
                System.out.println("Previous player bet there's " + currentDiceNumberBet + " numbers " + currentDiceValueBet +
                        ", call layer (type 0), continue type 1");
                int secondBet = scan.nextInt();
                secondTurn = true;
                switch (secondBet) {
                    case 0:
                        liarCheck();
                    default:
                        System.out.println(currentPlayer.name + " What's the number of dices you are betting?");
                        numberDicesBet = scan.nextInt();
                        currentDiceNumberBet = numberDicesBet;
                        System.out.println(currentPlayer.name + " What's the value of the dices you are betting?");
                        valueDicesBet = scan.nextInt();
                }
            } else {
               return;
            }

    }

    public void continueBet() {
        if(currentDiceValueBet != 6) {
            System.out.println(currentPlayer.name + " choose your second bet.");
            System.out.println("Select Option 1 or 2:");
            System.out.println("1 - Increase the value of the die you bet");
            System.out.println(" " +
                    " 8");
        }
    }

    public void liarCheck() {
            int countRepetition = Collections.frequency(tableDice.tableDice, valueDicesBet);
            if(countRepetition == valueDicesBet) {
                System.out.println("previous player is laying");
                dice.removeDie(currentPlayer);
                secondTurn = false;
                tableDice.tableDice.clear();
                currentDiceNumberBet = 0;
                round();
                //check playerCount
            } else {
                System.out.println(currentPlayer.name + " is wrong");
                dice.removeDie(currentPlayer);
                secondTurn = false;
                tableDice.tableDice.clear();
                currentDiceNumberBet = 0;
                if(currentPlayer.active == false){
                    playerCount--;
                }
                round();
            }
    }

    public String checkGameState() {
        if (playerCount == 1) {
            System.out.println("Game Over " + currentPlayer.name + " Wins!");
            isActive = false;
        }
        if(isActive) {
            return "Round is over!";
        } else {
            return "Game Over.";
        }
    }

}
