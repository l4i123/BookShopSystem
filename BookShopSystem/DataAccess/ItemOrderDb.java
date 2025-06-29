package DataAccess;

import Model.ItemOrder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemOrderDb {
    private final Connection connection;

    public ItemOrderDb(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(ItemOrder itemOrder) {
        String sql = "INSERT INTO OrderItems (order_id, book_id, quantity) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, itemOrder.getOrderId());
            stmt.setInt(2, itemOrder.getBookId());
            stmt.setInt(3, itemOrder.getQuantity());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ItemOrder> findByOrderId(int orderId) {
        List<ItemOrder> items = new ArrayList<>();
        String sql = "SELECT * FROM OrderItems WHERE order_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItemOrder item = new ItemOrder(
                    rs.getInt("order_id"),
                    rs.getInt("quantity"),
                    rs.getInt("book_id")
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public boolean delete(int itemOrderId) {
        String sql = "DELETE FROM OrderItems WHERE idOrderItem = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, itemOrderId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
