package MoreExercises;

import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input array of times
        String[] input = scanner.nextLine().split(" ");
        int[] raceTimes = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            raceTimes[i] = Integer.parseInt(input[i]);
        }

        int finishLine = raceTimes.length / 2;


        double leftRacerTime = 0;
        for (int i = 0; i < finishLine; i++) {
            leftRacerTime += raceTimes[i];
            if (raceTimes[i] == 0) {
                leftRacerTime *= 0.8;
            }
        }


        double rightRacerTime = 0;
        for (int i = raceTimes.length - 1; i > finishLine; i--) {
            rightRacerTime += raceTimes[i];
            if (raceTimes[i] == 0) {
                rightRacerTime *= 0.8;
            }
        }

        // Determine the winner and print the result
        if (leftRacerTime < rightRacerTime) {
            System.out.printf("The winner is left with total time: %.1f%n", leftRacerTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f%n", rightRacerTime);
        }
    }
}
