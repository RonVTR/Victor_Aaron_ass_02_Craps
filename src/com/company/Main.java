package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        // first roll
        int die1 = rand.nextInt(1, 7);
        int die2 = rand.nextInt(1, 7);
        final int firstSum = die1 + die2;
        System.out.printf("%d + %d = %d %n", die1, die2, firstSum);

        // Check wins or loses on first roll.
        if (firstSum == 7 || firstSum == 11) {
            System.out.println("Natural You win.");
            return;
        }
        if (firstSum == 2 || firstSum == 3 || firstSum == 12) {
            System.out.println("CRAPS You lose.");
            return;
        }

        // no win or loss on the first roll keep
        // rolling until the new sum matches the first one or is equal
        // to 7.
        int newSum = 0;
        while (newSum != firstSum && newSum != 7) {
            die1 = rand.nextInt(1, 7);
            die2 = rand.nextInt(1, 7);
            newSum = die1 + die2;
            System.out.printf("%d + %d = %d %n", die1, die2, newSum);
        }

        if (newSum == firstSum) {
            System.out.println("Natural You win.");
        } else {
            System.out.println("Craps You lose.");
        }
    }
}
