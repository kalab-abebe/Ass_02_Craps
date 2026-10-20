import java.util.Random;
import java.util.Scanner;

public class crapsgame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        String playChoice = "y";

        System.out.println("Welcome to the Craps Game!");

        // Loop to keep playing multiple rounds
        while (playChoice.equalsIgnoreCase("y")) {
            // Roll two dice (random numbers from 1 to 6)
            int die1 = rand.nextInt(6) + 1;
            int die2 = rand.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("\n--------------------------------");
            System.out.println("You rolled a " + die1 + " and a " + die2 + ". Total sum: " + sum);

            // Check initial roll conditions
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost.");
            }
            else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            }
            else {
                // Point is set
                int point = sum;
                System.out.println("The point is set to " + point);

                boolean rollingForPoint = true;

                // Keep rolling until point is made or a 7 is rolled
                while (rollingForPoint) {
                    System.out.print("Press Enter to roll again...");
                    input.nextLine();

                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made your point! You win!");
                        rollingForPoint = false;
                    }
                    else if (sum == 7) {
                        System.out.println("Rolled a 7. You lost!");
                        rollingForPoint = false;
                    }
                    else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Bulletproof prompt for playing again
            while (true) {
                System.out.print("\nWould you like to play again? (y/n): ");
                playChoice = input.nextLine().trim();

                if (playChoice.equalsIgnoreCase("y") || playChoice.equalsIgnoreCase("n")) {
                    break;
                }
                System.out.println("Invalid input. Please just type 'y' or 'n'.");
            }
        }

        System.out.println("\nThanks for playing!");
        input.close();
    }
}