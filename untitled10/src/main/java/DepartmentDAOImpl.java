import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    private SessionFactory sessionFactory;

    public DepartmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Department.class, id);
    }

    @Override
    public void updateDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.update(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = sessionFactory.getCurrentSession();
        Query<Department> query = session.createQuery("FROM Department", Department.class);
        return query.getResultList();
    }

    @Override
    public Department getDepartmentByMaxEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Department> query = session.createQuery("FROM Department ORDER BY maxEmployeeNumber DESC", Department.class);
        query.setMaxResults(1);
        return query.uniqueResult();
    }
}