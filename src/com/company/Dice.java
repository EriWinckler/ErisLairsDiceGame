package com.company;

import java.util.Collections;
import java.util.Random;

public class Dice {

    Random random = new Random();


    public void rollDice(Player player) {

        player.diceValue.clear();
        for (int i = 0; i < player.remainingDices; ++i) {
            player.diceValue.add(random.nextInt(6) + 1 );
        }

        //Sort the ArrayList
        Collections.sort(player.diceValue);

        System.out.print(player.name + " rolled " + player.diceValue);
        System.out.println("");
    }

    public void removeDie(Player player) {
        if (player.remainingDices > 0) {
            player.remainingDices = player.remainingDices - 1;
        } else {
            player.active = false;
            System.out.println(player.name + " is out!!");
        }
    }

}
