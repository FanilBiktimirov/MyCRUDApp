package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import web.UserDAO.JpaUserDAO;
import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private JpaUserDAO jpaUserDAO;

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void update(long id, User updatedUser) {

    }

    @Override
    public void delete(long id) {

    }
}
