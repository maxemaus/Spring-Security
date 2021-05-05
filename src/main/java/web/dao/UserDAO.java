package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsersList();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User findById(Long id);
}
