package games.rock_scissors_paper;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main_RO_PA_SC {
    public static void main(String[] args) {
        //Actualization 1.4
        intro();
    }
    public static void intro() {
        Scanner scanner = new Scanner(System.in);
        int start_finish = 4;
        while (start_finish >= 1) {
            System.out.println("\nWrite 1 to start the game, write 0 to finish it...");
            try {
                start_finish = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Just write 1 or 0... Try again.");
                intro();
            }
            if (start_finish == 1) {
                timesOfGame();
            } else if (start_finish == 0) {
                break;
            } else {
                System.out.println("Option is not valid, please try again.");
            }
        }
        System.out.println("\nTHANKS FOR PLAYING!");
    }
    public static void timesOfGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many times do you want to play?");
        System.out.print("3, 5 or 7: ");
        int timesForPlaying = 0;

        try {
            timesForPlaying = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n" + e + ".");
            System.out.println("DO NOT write letters!\n");
            timesOfGame();
        }
        switch (timesForPlaying) {
            case 3 -> startGame(3);
            case 5 -> startGame(5);
            case 7 -> startGame(7);
            default -> {
                System.out.println("Just select 3, 5 or 7");
                timesOfGame();
            }
        }
    }
    public static void startGame(int timesForPlaying) {
        Scanner scanner = new Scanner(System.in); Random random = new Random();

        System.out.print("Write your name player!: "); String namePlayer = scanner.nextLine();

        System.out.println("Welcome " + namePlayer + "! Let's start the game." );

        int points_player = 0, points_machine = 0;

        System.out.println("The best of " + timesForPlaying + " times wins! Good luck!");
        System.out.println("Select: ");
        System.out.println("1- Paper");
        System.out.println("2- Scissors");
        System.out.println("3- Rock\n");

        for (int times = 0; times < timesForPlaying; times++) {

            int opponent = random.nextInt(1, 4);
            int your_choose;
            try {
                your_choose = keyWork();
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
                    System.out.println("The option that you wrote, it was correct. Please try again.");
                    System.out.println("JUST select: ");
                    System.out.println("1- Paper");
                    System.out.println("2- Scissors");
                    System.out.println("3- Rock\n");
                    times--;
                }
            } catch (InputMismatchException e) {
                keyWork();
            }
        }
        if (points_machine > points_player) System.out.println(namePlayer + ", you have lost... sorry, try again.");
        else if (points_player > points_machine) System.out.println(namePlayer + " have Won! congratulations!");
        else System.out.println("TIE!");
        System.out.println("Machine= " + points_machine);
        System.out.println(namePlayer + "= " + points_player);
    }
    public static int keyWork() {
        Scanner scanner = new Scanner(System.in);
        int MyOption = 0;
        try {
            MyOption = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e + ".");
            System.out.println("DO NOT write letters! Write any number to leave the exception.\n");
            keyWork();
        }
        return MyOption;
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
