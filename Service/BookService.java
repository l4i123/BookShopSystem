package Service;

import DataAccess.BookDb;
import Model.Book;

import java.sql.Connection;
import java.util.List;

public class BookService {
    private final BookDb bookDb;

    public BookService(Connection connection) {
        this.bookDb = new BookDb(connection);
    }

    public List<Book> getAllBooks() {
        return bookDb.findAll();
    }

    public Book getBookById(int id) {
        return bookDb.findById(id);
    }

    public boolean updateQuantity(int bookId, int newQuantity) {
        return bookDb.updateQuantity(bookId, newQuantity);
    }

    public boolean addBook(Book book) {
        return bookDb.insert(book);
    }

    public boolean deleteBook(int bookId) {
        return bookDb.delete(bookId);
    }
}
