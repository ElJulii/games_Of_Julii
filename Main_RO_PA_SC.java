package games.rock_scissors_paper;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main_RO_PA_SC {
    public static void main(String[] args) {
        //Actualization 1.1
        intro();
    }
    public static void intro() {
        Scanner scanner = new Scanner(System.in);
        int start_finish = 3;
        while (start_finish > 0) {
            System.out.println("\nWrite 1 to start the game, write 2 to finish it...");
            try {
                start_finish = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Just write 1 or 2... Try again.");
                intro();
            }
            if (start_finish == 1) {
                startGame();
            } else if (start_finish == 2) {
                break;
            } else {
                System.out.println("Option is not valid, try again");
            }
        }
        System.out.println("\nTHANKS FOR PLAYING!");
    }
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Write your name player!: ");
        String namePlayer = scanner.nextLine();

        System.out.println("Welcome " + namePlayer + "! Let's start the game." );

        int points_player = 0, points_machine = 0;

        System.out.println("The best of five times wins! Good luck!");
        System.out.println("Select: ");
        System.out.println("1- paper");
        System.out.println("2- scissors");
        System.out.println("3- rock\n");

        for (int times = 0; times < 5; times++) {
            int your_choose = scanner.nextInt();
            int opponent = random.nextInt(1, 4);

            if (your_choose == opponent) System.out.println("Equals.\n");
            else if (your_choose == 1) {
                paper(opponent);
                if (opponent == 2) points_machine++;
                else points_player++;
            }  else if (your_choose == 2) {
                scissors(opponent);
                if (opponent == 3) points_machine++;
                else points_player++;
            }  else if (your_choose == 3) {
                rock(opponent);
                if (opponent == 1) points_machine++;
                else points_player++;
            } else {
                System.out.println("Option is not valid, please try again.\n");
                times--;
            }
        }
        if (points_machine > points_player) System.out.println(namePlayer + ", you have lost... sorry, try again.");
        else if (points_player > points_machine) System.out.println(namePlayer + " have Won! congratulations!");
        else System.out.println("TIE!");
        System.out.println("Machine= " + points_machine);
        System.out.println(namePlayer + "= " + points_player);
    }
    public static void paper(int machine_Option) {
        if (machine_Option == 2) {
            System.out.println("You MISS a point!");
            System.out.println("Machine: SCISSORS\n");
        }
        else {
            System.out.println("You WIN a point!");
            System.out.println("Machine: ROCK\n");
        }
    }
    public static void scissors(int machine_Option) {
        if (machine_Option == 3) {
            System.out.println("You MISS a point!");
            System.out.println("Machine: ROCK\n");
        }
        else {
            System.out.println("You WIN a point!");
            System.out.println("Machine: PAPER\n");
        }
    }
    public static void rock(int machine_Option) {
        if (machine_Option == 1) {
            System.out.println("You MISS a point!");
            System.out.println("Machine: PAPER\n");
        }
        else {
            System.out.println("You WIN a point!");
            System.out.println("Machine: SCISSORS\n");
        }
    }
}
