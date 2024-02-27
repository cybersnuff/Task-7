package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    public User getUser(int id);

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void updateUser(int id, User user);

    public void deleteUser(int id);

}
