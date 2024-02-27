package web.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }


    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("from User", User.class).getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {

        Session session = sessionFactory.getCurrentSession();

        if (user.getId() == 0) {
            session.save(user);
        } else {
            session.update(user);
        }

    }

    @Override
    public void updateUser(int id, User user) {
        Session session = sessionFactory.getCurrentSession();

        User user1 = getUser(id);

        user.setName(user1.getName());
        user.setDepartment(user1.getDepartment());
        user.setSalary(user1.getSalary());

        session.update(user);

    }

    @Override
    public void deleteUser(int id) {

        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, id);

        session.delete(user);

    }

}
