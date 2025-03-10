import java.util.ArrayList;
import java.util.List;

public class Task {
    private String id;
    private String description;
    private Employee assignedEmployee;
    private boolean completed;
    private List<TimeLog> timeLogs;

    public Task(String id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
        this.timeLogs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void assignEmployee(Employee employee) {
        this.assignedEmployee = employee;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void logTime(Employee employee, int hours) {
        TimeLog timeLog = new TimeLog(employee, this, hours);
        timeLogs.add(timeLog);
    }

    public int getTotalTimeSpent() {
        return timeLogs.stream().mapToInt(TimeLog::getHours).sum();
    }
}