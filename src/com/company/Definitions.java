package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Definitions {

    Scanner scan = new Scanner(System.in);

    Dice dice = new Dice();
    TableDice table = new TableDice();

    private Player currentPlayer;
    private Player previousPlayer;
    private Player playerChecker;
    private Player roller;

    private int numPlayers;
    private int playerCount;

    //loop conditionals
    private boolean firstTurn = true;
    private boolean secondTurn = false;
    private boolean gameOn = true;
    private boolean isActive = true;

    //Initializing players array
    public ArrayList<Player> players = new ArrayList<>();

    //Initializing values used for bet
    private int currentDiceNumberBet = 0;
    private int numberDicesBet;
    private int valueDicesBet;
    private String decision;
    private int currentDiceValueBet;

    //Initialize round counter
    private int round;


    //Initiating the game
    public void start() {
        while(gameOn) {
            System.out.println("Welcome to Eri's liars dice game!");
            System.out.println("");
            System.out.println("How many players are playing?");
            numPlayers = Integer.parseInt(scan.nextLine());

            if (numPlayers < 2) {
                System.out.println("Invalid number of players, please select " +
                        "between 2-10.");
                start();
            }

            System.out.println("How many dices?");
            int die = Integer.parseInt(scan.nextLine());

            while (numPlayers > players.size()) {
                players.add(createNewPlayer(die));
            }

            while (isActive) {
                round();
            }
        }
    }

    private Player createNewPlayer(int die) {
        Player newPlayer = new Player();
        System.out.println("Whats the player name?");
        String name = scan.nextLine();
        newPlayer.setName(name);
        newPlayer.setRemainingDices(die);
        newPlayer.setTotalDices(die);
        dice.rollDice(newPlayer);
        playerCount++;
        return newPlayer;
    }

    //Game round method
    public void round() {
        //Round counter
        round += 1;
        checkGameState();
        while(gameOn) {

            for (int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);
                if (currentPlayer.getRemainingDices() == 0) {
                    checkGameState();
                } else {
                    System.out.println("It's " + currentPlayer.getName() + " turn," +
                            " " + "other players please look away.");
                    Player.handCheck(currentPlayer);

                    if (secondTurn) {
                        dice.rollDice(currentPlayer);
                        table.addAll(currentPlayer.getDiceValue());
                        continueBet();
                    }

                    //Betting method
                    bet();
                    System.out.println("\n\n\n");
                }
            }
        }
    }

    //Betting method
    public void bet() {
        while(firstTurn) {
            System.out.println("What's the number of dices you are betting?");
            numberDicesBet = scan.nextInt();
            currentDiceNumberBet = numberDicesBet;

            System.out.println("What's the value of the dices you are betting?");
            valueDicesBet = scan.nextInt();
            currentDiceValueBet = valueDicesBet;
            previousPlayer = currentPlayer;
            firstTurn = false;
            secondTurn = true;

        }
    }

    public void continueBet() {
        System.out.println("Previous player bet there's " + currentDiceNumberBet + " dices " + currentDiceValueBet);
        System.out.println("Do you choose to:");
        System.out.println("1 - Call him a liar");
        System.out.println("2 - Make a new bet");
        scan.nextLine();
        decision = scan.nextLine();
        switch(decision) {
            case "1":
                liarCheck();
                break;

            case "2":
                if (currentDiceValueBet != currentPlayer.getTotalDices()) {
                    System.out.println(currentPlayer.getName() + " You can only select option 1 or 2:");
                    System.out.println("1 - Increase the amount of dice keeping the same value.");
                    System.out.println("2 - Change the value of dice and the quantity.");
                    decision = "0";
                    decision = scan.nextLine();
                    previousPlayer = currentPlayer;
                } else {
                    System.out.println(currentPlayer.getName() + " as the dice value is at maximum, you can only increase the quantity");
                    decision = "2";
                    previousPlayer = currentPlayer;
                }

                switch (decision) {
                    case "1":
                        System.out.println("The last bet was " + currentDiceNumberBet + " dices " + currentDiceValueBet);
                        do {
                            System.out.println("Whats the new number of dices for the new bet?");
                            numberDicesBet = scan.nextInt();
                            break;
                        } while (numberDicesBet <= currentDiceNumberBet);
                        currentDiceNumberBet = numberDicesBet;
                        break;

                    case "2":
                        do {
                            System.out.println("The current number of dices bet is " + currentDiceNumberBet + " how much would you like to increase?");
                            numberDicesBet = scan.nextInt();
                            numberDicesBet = currentDiceNumberBet;
                            break;
                        } while (numberDicesBet <= currentDiceNumberBet);

                        System.out.println("What's the number of the die value would you like to bet? It can be any value.");
                        valueDicesBet = scan.nextInt();
                        valueDicesBet = currentDiceValueBet;
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }
        }
    }

    public void liarCheck() {
        int countRepetition = Collections.frequency(table.tableDice, valueDicesBet);
        if (countRepetition == currentDiceValueBet) {
            System.out.println(previousPlayer + " player is laying");
            dice.removeDie(previousPlayer);

            if (currentPlayer.getDiceValue().size() == 0) {
                playerCount--;
            }

            //clearing variables
            table.tableDice.clear();
            currentDiceNumberBet = 0;
            currentDiceValueBet = 0;
            firstTurn = true;
            secondTurn = false;
            rattleTheBucket();

            round();
        } else {
            System.out.println(currentPlayer.getName() + " is mistaken in calling the liar");
            dice.removeDie(currentPlayer);

            if (currentPlayer.getDiceValue().size() == 0) {
                playerCount--;
            }
            //clearing variables
            table.tableDice.clear();
            currentDiceNumberBet = 0;
            currentDiceValueBet = 0;
            firstTurn = true;
            secondTurn = false;
            rattleTheBucket();

            round();
        }
    }

    public void playerChecker() {
        for (int i = 0; i < players.size(); i++) {
            playerChecker = players.get(i);
            if(playerChecker.getPlayerActive()) {
                playerChecker.getRemainingPlayerName().add(playerChecker.getName());
            }
        }
    }

    public void checkGameState() {
        if (playerCount == 1) {
            playerChecker();
            System.out.println("Game Over " + currentPlayer.getRemainingPlayerName() + " Wins in " + round + " rounds");
            isActive = false;
            gameOn = false;
        }
    }

    public void rattleTheBucket() {
        for (int i = 0; i < players.size(); i++) {
            roller = players.get(i);
            dice.rollDice(roller);
        }
    }
}
