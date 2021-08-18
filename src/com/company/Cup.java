package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Cup {
    public static ArrayList<Integer> dices = new ArrayList<>();

    public void startDice(int dicesNumber) {
        Random random = new Random();
        for (int i = 0; i < 6; ++i) {
            dices.add(random.nextInt(6) + 1 );
        }

        //Sort dices
        Collections.sort(dices);

        System.out.println("Your cup holds " + dices);
    }

}
