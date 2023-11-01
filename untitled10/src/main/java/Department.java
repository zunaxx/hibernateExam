import jakarta.persistence.*;
import lombok.Lombok;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int maxEmployeeNumber;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    public Department(Long id, String name, int maxEmployeeNumber, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.maxEmployeeNumber = maxEmployeeNumber;
        this.employees = employees;
    }

    public Department() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxEmployeeNumber() {
        return maxEmployeeNumber;
    }

    public void setMaxEmployeeNumber(int maxEmployeeNumber) {
        this.maxEmployeeNumber = maxEmployeeNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxEmployeeNumber=" + maxEmployeeNumber +
                ", employees=" + employees +
                '}';
    }
}