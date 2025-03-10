import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String id;
    private String name;
    private List<TimeLog> timeLogs;
    private List<Task> tasks;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
        this.timeLogs = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void logTime(Task task, int hours) {
        TimeLog timeLog = new TimeLog(this, task, hours);
        timeLogs.add(timeLog);
    }

    public List<TimeLog> getTimeLogs() {
        return timeLogs;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}