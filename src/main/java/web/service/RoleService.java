package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDAO;
import web.model.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    final
    RoleDAO roleDAO;

    @Autowired
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    public Role getRoleById(long id) {
        return roleDAO.getRoleById(id);
    }
    public List<Role> getRolesList() {
        return roleDAO.getRolesList();
    }
}
