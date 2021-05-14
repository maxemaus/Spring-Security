package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getUsersList();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User findById(Long id);
    User getUserByName(String name);
    Set<Role> getSetOfRoles(List<String> rolesId);
}
