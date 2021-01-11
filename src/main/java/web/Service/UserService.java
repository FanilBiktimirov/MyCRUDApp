package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    User getUserById(long id);
    void saveUser(User user);
    void update(long id, User updatedUser);
    void delete(long id);

}
