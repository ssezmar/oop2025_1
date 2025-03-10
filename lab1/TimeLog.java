public class TimeLog {
    private Employee employee;
    private Task task;
    private int hours;

    public TimeLog(Employee employee, Task task, int hours) {
        this.employee = employee;
        this.task = task;
        this.hours = hours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Task getTask() {
        return task;
    }

    public int getHours() {
        return hours;
    }
}