package cinema.spring.service;

import cinema.spring.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
