import UI. BrowseBooks;
import UI.LoginMenu;
import Service.BookService;
import Helper.DBConnection;

public class Main {
    public static void main(String[] args) {
        try {
            
            var BrowseBooks = new BrowseBooks(new BookService(DBConnection.getConnection()));
            BrowseBooks.display();
            
            var LoginMenu = new LoginMenu();
            LoginMenu.display();

        } catch (Exception e) {
            System.out.println("Error starting app: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
