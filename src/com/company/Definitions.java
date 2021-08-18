package com.company;

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

    //Initialize round counter
    int round;

    //Checker if game is still on
    boolean isActive = true;

    //Checker for calling liar
    boolean isLiar = false;


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
            System.out.println("What's the number of dices you are betting?");
            numberDicesBet = scan.nextInt();
            System.out.println("What's the value of the dices you are betting?");
            valueDicesBet = scan.nextInt();

            System.out.println("");
            System.out.println("");
            System.out.println("");

            System.out.println("It's " + player2.name + " turn, are you ready? (y)");
            String rdy = scan.nextLine();


            //create loop for y/n answer
            String answer = scan.nextLine();

            dice.rollDice(player2);
            System.out.println(player1.name + " bet " + numberDicesBet + " dices " + " " + valueDicesBet);
            System.out.println("What's your bet? Or you wish to call " + player1.name + " a liar (type 0)?");

            //create conditional for calling liar
            System.out.println("What's the number of dices you are betting?");
            numberDicesChallenge = scan.nextInt();
            System.out.println("What's the value of the dices you are betting?");
            valueDicesChallenge = scan.nextInt();

        }
    }

    //Betting method
    public void bet() {
        System.out.println("What's the number of dices you are betting?");
        numberDicesBet = scan.nextInt();
        System.out.println("What's the value of the dices you are betting?");
        valueDicesBet = scan.nextInt();


        if (numberDicesChallenge < numberDicesBet) {
            System.out.println("Invalid bet, please select a valid number of dices");
            //return questions
        }

        if(isLiar == true) {

        }

    }



}
