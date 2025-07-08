package UI;

import Service.BookService;
import Service.UserService;
import Service.OrderService;
import Model.User;
import Helper.Constants;
import Helper.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class LoginMenu {
    private final UserService userService;
    private final Scanner scanner = new Scanner(System.in);
    

    public LoginMenu() {
        try {
            Connection conn = DBConnection.getConnection();
            this.userService = new UserService(conn);
        } catch (Exception e) {
            throw new RuntimeException("Cannot connect to database");
        }
    }

    public void display() {
        System.out.println("Welcome!");
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": login(); break;
                case "2": register(); break;
                case "3": return;
                default: System.out.println("Invalid option");
            }
        }
    }
    private void login(){
        System.out.println("Enter Email:");
        String email= scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        if(email.isEmpty()|| password.isEmpty()){
            System.out.println(Constants.ERROR_INVALID_INPUT);
            return;
        }
        User user = userService.getUserByEmail(email);
        if(user != null && userService.checkPassword(user, password)){
            System.out.println("Login successful! Welcome " + user.getUserName());
            try{
            Connection connection = DBConnection.getConnection();
            BookService bookService = new BookService(connection);
            OrderService orderService = new OrderService(connection);
            
            MainMenu mainMenu = new MainMenu( bookService,  orderService,  user.getUserId());
            mainMenu.display();
            } catch (Exception e) {
                System.out.println("Error loading Menu app: " + e.getMessage());
                e.printStackTrace();
            }
            
        } else {
            System.out.println(Constants.ERROR_INVALID_CREDENTIALS);
        }
    }
    private void register() {
        System.out.println("Enter Username:");
        String userName = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();
        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        if(userName.isEmpty() || password.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()){
            System.out.println(Constants.ERROR_INVALID_INPUT);
            return;
        }

        User newUser = new User(userName, password, email, phoneNumber, address);
        if(userService.getUserByEmail(email) != null){
            System.out.println(Constants.ERROR_EMAIL_ALREADY_EXISTS);
            return;
        }
        if(userService.saveUser(newUser)){
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }


    
}
