package DataAccess;

import Model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDb {
    private final Connection connection;

    public BookDb(Connection connection) {
        this.connection = connection;
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM Books";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("idBooks"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getObject("onSale_id") != null ? rs.getInt("onSale_id") : null
                );
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book findById(int id) {
        String query = "SELECT * FROM Books WHERE idBooks = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Book(
                    rs.getInt("idBooks"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getObject("onSale_id") != null ? rs.getInt("onSale_id") : null
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Book book) {
        String query = "INSERT INTO Books (title, author, category, price, quantity, onSale_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getCategory());
            stmt.setDouble(4, book.getPrice());
            stmt.setInt(5, book.getQuantity());

            if (book.getIdOnSale() != null) {
                stmt.setInt(6, book.getIdOnSale());
            } else {
                stmt.setNull(6, Types.INTEGER);
            }

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateQuantity(int bookId, int quantity) {
        String query = "UPDATE Books SET quantity = ? WHERE idBooks = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, bookId);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int bookId) {
        String query = "DELETE FROM Books WHERE idBooks = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bookId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
