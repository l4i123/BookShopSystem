package DataAccess;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDb {
    private Connection connection;

    public UserDb(Connection connection) {
        this.connection = connection;
    }
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try (var preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                    resultSet.getString("userName"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public User findByUserName(String userName) {
        String query = "SELECT * FROM users WHERE userName = ?";
        try (var preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userName);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                    resultSet.getString("userName"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean save(User user) {
        String query = "INSERT INTO User (username, password, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getAddress());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

    

