package utils;


import java.util.Scanner;

public class ConsoleUtils {
    public static void pause() {
        Scanner sc = new Scanner(System.in);
        System.out.println("press enter to continue");
        try {
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error at pausing : " + e.getMessage());
        }
    }

    public static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int option_validation(String statement, int lower, int upper) {// return a int >= lower and <= upper
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try{
                System.out.println(statement);
                int option = scanner.nextInt();
                scanner.nextLine();
                if (option >= lower && option <= upper) {
                    return option;
                } else {
                    System.out.println(String.format("You didn't choose a inverval in this boundaries: %1$d-%2$d",
                            lower, upper));
                    scanner.nextLine();
                    
                }

            } catch (Exception e) {
                System.out.println("Digit a valid number." + e.getMessage());
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
