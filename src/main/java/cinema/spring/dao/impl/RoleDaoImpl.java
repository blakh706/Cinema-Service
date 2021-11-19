package cinema.spring.dao.impl;

import cinema.spring.dao.AbstractDao;
import cinema.spring.dao.RoleDao;
import cinema.spring.exception.DataProcessingException;
import cinema.spring.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Role add(Role role) {
        return super.add(role);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> roleQuery = session.createQuery("From Role r where r.roleName = :roleName",
                    Role.class);
            roleQuery.setParameter("roleName", roleName);
            return roleQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find role by name" + roleName, e);
        }
    }
}
