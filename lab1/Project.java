import java.util.ArrayList;
import java.util.List;

public class Project {
    private String id;
    private String name;
    private List<Employee> employees;
    private List<Task> tasks;

    public Project(String id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new ArrayList<>();
        this.tasks = new ArrayList<>();
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

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int getTotalTimeSpent() {
        return tasks.stream().mapToInt(Task::getTotalTimeSpent).sum();
    }
}