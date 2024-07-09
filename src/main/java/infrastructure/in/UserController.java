package infrastructure.in;

import application.CreateUserUseCase;
import domain.entity.User;
import utils.ConsoleUtils;

import java.util.Scanner;

public class UserController {
    private  CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    public void start() {

        while (true) {
            ConsoleUtils.cleanScreen();
            displayMenu();
            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 6);
            switch (option) {
                case 1:
                // create player
                    try (Scanner scanner = new Scanner(System.in)) {
                        System.out.println("Enter user name: ");
                        String name = scanner.nextLine();
            
                        System.out.println("Enter user email: ");
                        String email = scanner.nextLine();
            
                        User user = new User();
                        user.setName(name);
                        user.setEmail(email);
            
                        createUserUseCase.execute(user);
                    }catch (Exception e) {
                        System.out.println("Error at creating a player: " + e.getMessage());
                        ConsoleUtils.pause();
                    }
            
                    System.out.println("User created successfully!");
                    

                    break;
                case 2:
                // update player
                case 3:
                // find player
                case 6:
                    return;
                default:
                    break;
            }            
        }
        
    }

       public void displayMenu() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------PLAYER MENU---------------------------------------");
        System.out.println("1. Create player");
        System.out.println("2. Update player");
        System.out.println("3. Find player");
        System.out.println("4. Delete player");
        System.out.println("5. List all players");
        System.out.println("6. Go back");
    }
}
