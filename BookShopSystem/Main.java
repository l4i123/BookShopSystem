import UI.MainMenu;
import Service.BookService;
import Service.OrderService;
import Helper.DBConnection;

public class Main {
    public static void main(String[] args) {
        try {
            var connection = DBConnection.getConnection();
            var bookService = new BookService(connection);
            var orderService = new OrderService(connection);
            
            int userId = 1; 
            
            var mainMenu = new MainMenu(bookService, orderService, userId);
            mainMenu.display();
        } catch (Exception e) {
            System.out.println("Error starting app: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
