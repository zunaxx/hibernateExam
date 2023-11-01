import java.util.List;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    List<Employee> getAllEmployees();
    List<Employee> getAllEmployeesSortedBySalary();
}