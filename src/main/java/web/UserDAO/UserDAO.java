package web.UserDAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUserList();
    User getUserById(long id);
    void saveUser(User user);
    void update(User updatedUser);
    void delete(long id);
}
