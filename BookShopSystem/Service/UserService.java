package Service;

import DataAccess.UserDb;
import Model.User;
import java.sql.Connection;

public class UserService {

    private final UserDb userDb;

    public UserService(Connection connection) {
        this.userDb = new UserDb(connection);
    }

    public User getUserByEmail(String email) {
        return userDb.findByEmail(email);
    }
    public User getUserByName(String userName) {
        return userDb.findByUserName(userName);
    }

    public boolean checkPassword(User user, String password){
        return user.getPassword().equals(password);
    }

    public boolean checkEmail(User user, String email){
        return user.getEmail().equals(email);
    }
    public boolean saveUser(User user) {
        return userDb.save(user);
    }
}
