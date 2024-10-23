import java.util.*;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first player's deck
        Queue<Integer> firstPlayerDeck = new LinkedList<>();
        String[] firstDeckInput = scanner.nextLine().split(" ");
        for (String card : firstDeckInput) {
            firstPlayerDeck.offer(Integer.parseInt(card));
        }

        // Read the second player's deck
        Queue<Integer> secondPlayerDeck = new LinkedList<>();
        String[] secondDeckInput = scanner.nextLine().split(" ");
        for (String card : secondDeckInput) {
            secondPlayerDeck.offer(Integer.parseInt(card));
        }

        // Play the game
        while (!firstPlayerDeck.isEmpty() && !secondPlayerDeck.isEmpty()) {
            int firstPlayerCard = firstPlayerDeck.poll();
            int secondPlayerCard = secondPlayerDeck.poll();

            if (firstPlayerCard > secondPlayerCard) {
                // First player wins this round
                firstPlayerDeck.offer(firstPlayerCard); // The winner's card
                firstPlayerDeck.offer(secondPlayerCard); // The loser's card
            } else if (secondPlayerCard > firstPlayerCard) {
                // Second player wins this round
                secondPlayerDeck.offer(secondPlayerCard); // The winner's card
                secondPlayerDeck.offer(firstPlayerCard); // The loser's card
            }
            // If both cards are equal, no one wins the round, and both cards are discarded.
        }

        // Determine the winner and calculate the sum of remaining cards
        if (!firstPlayerDeck.isEmpty()) {
            int sum = firstPlayerDeck.stream().mapToInt(Integer::intValue).sum();
            System.out.println("First player wins! Sum: " + sum);
        } else if (!secondPlayerDeck.isEmpty()) {
            int sum = secondPlayerDeck.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
