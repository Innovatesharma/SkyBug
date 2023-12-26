import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI've selected a number between " + minRange + " and " + maxRange + ". Guess it!");

            while (attempts < attemptsLimit) {
                System.out.print("Attempt #" + (attempts + 1) + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number (" + randomNumber + ") in " + (attempts + 1) + " attempts!");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try a higher number!");
                } else {
                    System.out.println("Too high. Try a lower number!");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();

            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nYour total score: " + score);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
