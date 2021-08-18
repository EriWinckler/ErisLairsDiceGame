package com.company;

import java.util.Collections;
import java.util.Scanner;

public class Definitions {

    Scanner scan = new Scanner(System.in);

    Dice dice = new Dice();
    Player player1 = new Player();
    Player player2 = new Player();

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

    //Operator for checking liar callinh
    int comparationValue;


    //Initiating the game
    public void startGame() {
        System.out.println("Welcome to Eri's liars dice game!");
        System.out.println("");
        System.out.println("Whats the First player name?");
        player1.name = scan.nextLine();

        System.out.println("");
        System.out.println("Whats the Second player name?");
        player2.name = scan.nextLine();

        System.out.println("Let the game begin!");

        round();
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
            //create method for the betting system
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
            System.out.println("Previous player bet there's " + cu);
            currentDiceNumberBet = numberDicesBet;
            System.out.println("What's the value of the dices you are betting?");
            valueDicesBet = scan.nextInt();
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
            } else {
                System.out.println(player1.name + " is liar calling was wrong");
            }
        }

    }



}
