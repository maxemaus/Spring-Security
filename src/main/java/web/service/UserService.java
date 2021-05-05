package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User findById(Long id);
}
