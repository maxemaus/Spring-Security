package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceimpl implements UserService{

    private final UserDAO userDAO;
    @Autowired
    public UserServiceimpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsersList() {
        return userDAO.getUsersList();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return userDAO.findById(id);
    }
}
