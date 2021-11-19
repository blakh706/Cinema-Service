package cinema.spring.service.impl;

import cinema.spring.dao.RoleDao;
import cinema.spring.exception.DataProcessingException;
import cinema.spring.model.Role;
import cinema.spring.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName)
                .orElseThrow(() -> new DataProcessingException("There are no role with name "
                        + roleName));
    }
}
