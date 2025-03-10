import java.util.ArrayList;
import java.util.List;

public class Department {
    private String id;
    private String name;
    private List<Employee> employees;
    private List<Project> projects;

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }
}