package UI;

import Model.Book;
import Model.Orders;
import Service.BookService;
import Service.OrderService;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final BookService bookService;
    private final OrderService orderService;
    private final int userId;
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(BookService bookService, OrderService orderService, int userId) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.userId = userId;
    }

    public void display() {
        System.out.println("\nWelcome to the BookShop!");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Make Order");
            System.out.println("3. My Orders");
            System.out.println("4. Logout");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    bookService.getAllBooks().forEach(book ->
                            System.out.printf("ID: %d | %s by %s | %.2f BGN | Qty: %d\n",
                                    book.getIdBook(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getQuantity()));
                    break;
                case "2":
                    makeOrder();
                    break;
                case "3":
                    List<Orders> orders = orderService.getOrdersByUserId(userId);
                    for (Orders o : orders) {
                        System.out.printf("Order #%d | Status: %s | Total: %.2f\n", o.getOrderId(), o.getStatus(), o.getTotalAmount());
                    }
                    break;
                case "4":
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private void makeOrder() {
        int orderId = orderService.createOrder(userId);
        double total = 0;

        while (true) {
            System.out.print("Enter book ID (or 0 to finish): ");
            int bookId = Integer.parseInt(scanner.nextLine());
            if (bookId == 0) break;

            Book book = bookService.getBookById(bookId);
            if (book == null) {
                System.out.println("Book not found.");
                continue;
            }

            System.out.print("Quantity: ");
            int qty = Integer.parseInt(scanner.nextLine());

            if (qty > book.getQuantity()) {
                System.out.println("Not enough stock.");
                continue;
            }

            if (orderService.addBookToOrder(orderId, book, qty)) {
                double subtotal = book.getPrice() * qty;
                total += subtotal;
                bookService.updateQuantity(book.getIdBook(), book.getQuantity() - qty);
                System.out.printf("Added %d x %s to order. Subtotal: %.2f\n", qty, book.getTitle(), subtotal);
            } else {
                System.out.println("Failed to add to order.");
            }
        }

        orderService.finalizeOrder(orderId, total);
        System.out.println("Order completed! Total: " + total + " BGN");
    }
}
