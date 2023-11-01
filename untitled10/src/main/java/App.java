import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    private static DepartmentDAO departmentDAO;
    private EmployeeDAO employeeDAO;

    public App(DepartmentDAO departmentDAO, EmployeeDAO employeeDAO) {
        this.departmentDAO = departmentDAO;
        this.employeeDAO = employeeDAO;
    }

    public void saveDepartment(Department department) {
        departmentDAO.saveDepartment(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentDAO.getDepartmentById(id);
    }

    public void updateDepartment(Department department) {
        departmentDAO.updateDepartment(department);
    }

    public void deleteDepartment(Department department) {
        departmentDAO.deleteDepartment(department);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    public Department getDepartmentByMaxEmployees() {
        return departmentDAO.getDepartmentByMaxEmployees();
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeDAO.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public List<Employee> getAllEmployeesSortedBySalary() {
        return employeeDAO.getAllEmployeesSortedBySalary();
    }

    public static void main(String[] args) {

        SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
                DepartmentDAO departmentDAO = new DepartmentDAOImpl(sessionFactory);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(sessionFactory);
        App app = new App(departmentDAO, employeeDAO);


        Department department = new Department();
        department.setName("IT Department");
        department.setMaxEmployeeNumber(100);
        app.saveDepartment(department);

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setAge(30);
        employee.setSalary(5000);
        employee.setDepartment(department);
        app.saveEmployee(employee);

        // Получение всех департаментов
        List<Department> departments = app.getAllDepartments();
        for (Department dept : departments) {
            System.out.println("Department Name: " + dept.getName());
        }

        // Получение всех сотрудников, отсортированных по зарплате
        List<Employee> employees = app.getAllEmployeesSortedBySalary();
        for (Employee emp : employees) {
            System.out.println("Employee Name: " + emp.getFirstName() + " " + emp.getLastName() + ", Salary: " + emp.getSalary());
        }
    }
}
