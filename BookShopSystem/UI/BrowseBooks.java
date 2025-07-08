package UI;

import Model.Book;
import Service.BookService;

import java.util.List;

public class BrowseBooks {
    private final BookService bookService;

    public BrowseBooks(BookService booksService) {
        this.bookService = booksService;
    }

    public void display() {
        System.out.println("=== Available Books ===");
        List<Book> books = bookService.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println("ID: " + book.getIdBook());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Price: " + book.getPrice() + " лв");
                System.out.println("Quantity: " + book.getQuantity());
                System.out.println(book.getIdOnSale() != null ? "On Sale" : "Regular Price");
                System.out.println("------------------------");
            }
        }
    }
}
