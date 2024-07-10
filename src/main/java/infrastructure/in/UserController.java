package infrastructure.in;

import application.CreateUserUseCase;
import application.FindUserUseCase;
import domain.entity.User;
import utils.ConsoleUtils;
import utils.MyScanner;



public class UserController {
    private CreateUserUseCase createUserUseCase;
    private FindUserUseCase findUserUseCase;
    public UserController(CreateUserUseCase createUserUseCase,FindUserUseCase findUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.findUserUseCase = findUserUseCase;
    }

    public void start() {

        while (true) {
            ConsoleUtils.cleanScreen();
            displayMenu();
            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 6);
            switch (option) {
                case 1:
                // create player
                    try {
                        System.out.println("Enter user name: ");
                        String name = MyScanner.scanLine();
            
                        System.out.println("Enter user email: ");
                        String email = MyScanner.scanLine();
            
                        User user = new User();
                        user.setName(name);
                        user.setEmail(email);
            
                        createUserUseCase.execute(user);
                    }catch (Exception e) {
                        System.out.println("Error at creating a player: " + e.getMessage());
                        ConsoleUtils.pause();
                    }
            
                    System.out.println("User created successfully!");
                    ConsoleUtils.pause();

                    break;
                case 2:

                case 3:
                    try {
                        System.out.println("Enter user id: ");
                        Long id = MyScanner.ScanLong();
                        User user = findUserUseCase.execute(id);
                        displayUserDetails(user);
                    } catch (Exception e) {
                        System.out.println("Invalid id.");
                    }
                    ConsoleUtils.pause();
                    break;
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

    public void displayUserDetails(User user){
        System.out.println("User id: " + user.getId());
        System.out.println("User name: " + user.getName());
        System.out.println("User email: " + user.getEmail());
    }
}
