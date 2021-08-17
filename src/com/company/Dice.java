package com.company;

import java.util.Collections;
import java.util.Random;

public class Dice {

    Random random = new Random();

    public void rollDice() {
        for (int i = 0; i < Player.remainingDices; ++i) {
            Player.diceValue.add(random.nextInt(6) + 1 );
        }

        //Sort the ArrayList
        Collections.sort(Player.diceValue);

        System.out.println("");
        System.out.print("You rolled  ");
    }


    //Method to populate dice array


}
