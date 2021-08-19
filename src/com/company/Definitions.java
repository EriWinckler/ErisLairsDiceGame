package com.company;

import java.util.Collections;
import java.util.Scanner;

public class Definitions {

    Scanner scan = new Scanner(System.in);

    Player player = new Player();
    Dice dice = new Dice();

    int numberDicesBet;
    int valueDicesBet;
    int numberDicesChallenge;
    int valueDicesChallenge;

    //Initializing values used for bet
    int currentDiceNumberBet = 0;
    int tryBet;

    //Initialize round counter
    int round;

    //Checker if game is still on
    boolean isActive = true;

    //Checker for calling liar
    boolean isLiar = false;

    //Operator for checking liar calling
    int comparationValue;


    //Initiating the game
    public void startGame() {
        System.out.println("Welcome to Eri's liars dice game!");
        System.out.println("");
        System.out.println("How many players are playing?");
        int numPlayers = scan.nextInt();
        System.out.println("How many dices?");
        int die = scan.nextInt();
        for(int i = 0; i <= numPlayers; i++) {

        }

        System.out.println("Whats the First player name?");
        player.name = scan.nextLine();



        while(isActive) {
            round();
        }

    }

    //Game round method
    public void round() {
        if(player1.remainingDices == 0) {
            System.out.println("Game Over! " + player2.name + " Wins! Number of rounds: " + round);
            isActive = false;
        } else if (player2.remainingDices == 0) {
            System.out.println("Game Over! " + player1.name + " Wins! Number of rounds: " + round);
            isActive = false;
        } else {
            //Round counter
            round += 1;

            System.out.println("It's " + player1.name + " turn, " + player2.name + " please look away.");
            dice.rollDice(player1);
            //Betting system
            bet();

            System.out.println("/n/n/n");

            System.out.println("It's " + player2.name + " turn, are you ready? (y)");
            String rdy = scan.nextLine();

            dice.rollDice(player2);
            //System.out.println(player1.name + " bet " + numberDicesBet + " dices " + " " + valueDicesBet);
            bet();

            //create conditional for calling liar
            System.out.println("What's the number of dices you are betting?");
            numberDicesChallenge = scan.nextInt();
            System.out.println("What's the value of the dices you are betting?");
            valueDicesChallenge = scan.nextInt();

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
            System.out.println("Previous player bet there's " + currentDiceNumberBet + " number " + valueDicesBet +
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
        if(isLiar == true) {
            int countRepetition =
                    Collections.frequency(player1.diceValue, valueDicesBet) + Collections.frequency(player2.diceValue, valueDicesBet);
            if(countRepetition == valueDicesBet) {
                System.out.println(player2.name + " is laying");
                dice.removeDie(player2);
            } else {
                System.out.println(player1.name + " is wrong");
                dice.removeDie(player1);
            }
        }



    }



}
