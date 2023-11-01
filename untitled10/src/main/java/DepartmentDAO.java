import java.util.List;

public interface DepartmentDAO {
    void saveDepartment(Department department);
    Department getDepartmentById(Long id);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentByMaxEmployees();
}