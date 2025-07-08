package DataAccess;

import Model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDb {
    private final Connection connection;

    public OrdersDb(Connection connection) {
        this.connection = connection;
    }

    public int createOrder(int userId) {
        String query = "INSERT INTO Orders (user_id, status) VALUES (?, 'PROCESSING')";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void updateTotalPrice(int orderId, double totalPrice) {
        String query = "UPDATE Orders SET total_price = ? WHERE idOrder = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, totalPrice);
            stmt.setInt(2, orderId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(int orderId, String status) {
        String query = "UPDATE Orders SET status = ? WHERE idOrder = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, orderId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Orders> getOrdersByUserId(int userId) {
        List<Orders> ordersList = new ArrayList<>();
        String query = "SELECT * FROM Orders WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Orders order = new Orders(
                        rs.getInt("idOrder"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("date").toLocalDateTime(),
                        rs.getString("status"),
                        rs.getDouble("total_price")
                );
                ordersList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }
}
