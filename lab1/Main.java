import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Department department = new Department("1", "IT Department");
    private ObservableList<Employee> employees = FXCollections.observableArrayList(department.getEmployees());
    private ObservableList<Project> projects = FXCollections.observableArrayList(department.getProjects());
    private ObservableList<Task> tasks = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Project Management");

        TabPane tabPane = new TabPane();

        Tab employeesTab = new Tab("Employees", createEmployeesTab());
        Tab projectsTab = new Tab("Projects", createProjectsTab());
        Tab tasksTab = new Tab("Tasks", createTasksTab());
        Tab reportsTab = new Tab("Reports", createReportsTab());

        tabPane.getTabs().addAll(employeesTab, projectsTab, tasksTab, reportsTab);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createEmployeesTab() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        TextField empIdField = new TextField();
        empIdField.setPromptText("Employee ID");

        TextField empNameField = new TextField();
        empNameField.setPromptText("Employee Name");

        Button addButton = new Button("Add Employee");
        addButton.setOnAction(event -> {
            String empId = empIdField.getText();
            String empName = empNameField.getText();
            Employee employee = new Employee(empId, empName);
            department.addEmployee(employee);
            employees.setAll(department.getEmployees());
            empIdField.clear();
            empNameField.clear();
        });

        Button removeButton = new Button("Remove Employee");
        removeButton.setOnAction(event -> {
            String empId = empIdField.getText();
            Employee employee = findEmployeeById(empId);
            if (employee != null) {
                department.removeEmployee(employee);
                employees.setAll(department.getEmployees());
            }
            empIdField.clear();
        });

        TableView<Employee> table = new TableView<>(employees);

        TableColumn<Employee, String> idColumn = new TableColumn<>("Employee ID");
        idColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));

        TableColumn<Employee, String> nameColumn = new TableColumn<>("Employee Name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        table.getColumns().addAll(idColumn, nameColumn);

        vbox.getChildren().addAll(new Label("Manage Employees"), empIdField, empNameField, addButton, removeButton, table);
        return vbox;
    }

    private VBox createProjectsTab() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        TextField projIdField = new TextField();
        projIdField.setPromptText("Project ID");

        TextField projNameField = new TextField();
        projNameField.setPromptText("Project Name");

        Button addButton = new Button("Add Project");
        addButton.setOnAction(event -> {
            String projId = projIdField.getText();
            String projName = projNameField.getText();
            Project project = new Project(projId, projName);
            department.addProject(project);
            projects.setAll(department.getProjects());
            projIdField.clear();
            projNameField.clear();
        });

        Button removeButton = new Button("Remove Project");
        removeButton.setOnAction(event -> {
            String projId = projIdField.getText();
            Project project = findProjectById(projId);
            if (project != null) {
                department.removeProject(project);
                projects.setAll(department.getProjects());
            }
            projIdField.clear();
        });

        TableView<Project> table = new TableView<>(projects);

        TableColumn<Project, String> idColumn = new TableColumn<>("Project ID");
        idColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));

        TableColumn<Project, String> nameColumn = new TableColumn<>("Project Name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        table.getColumns().addAll(idColumn, nameColumn);

        vbox.getChildren().addAll(new Label("Manage Projects"), projIdField, projNameField, addButton, removeButton, table);
        return vbox;
    }

    private VBox createTasksTab() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        TextField taskIdField = new TextField();
        taskIdField.setPromptText("Task ID");

        TextField taskDescField = new TextField();
        taskDescField.setPromptText("Task Description");

        TextField projIdField = new TextField();
        projIdField.setPromptText("Project ID");

        TextField empIdField = new TextField();
        empIdField.setPromptText("Employee ID");

        Button addButton = new Button("Add Task");
        addButton.setOnAction(event -> {
            String taskId = taskIdField.getText();
            String taskDesc = taskDescField.getText();
            String projId = projIdField.getText();
            Project project = findProjectById(projId);
            if (project != null) {
                Task task = new Task(taskId, taskDesc);
                project.addTask(task);
                updateTasks();
                taskIdField.clear();
                taskDescField.clear();
                projIdField.clear();
            }
        });

        Button assignButton = new Button("Assign Task");
        assignButton.setOnAction(event -> {
            String taskId = taskIdField.getText();
            String empId = empIdField.getText();
            Task task = findTaskById(taskId);
            Employee employee = findEmployeeById(empId);
            if (task != null && employee != null) {
                task.assignEmployee(employee);
                updateTasks();
                empIdField.clear();
            }
        });

        Button logTimeButton = new Button("Log Time");
        logTimeButton.setOnAction(event -> {
            String taskId = taskIdField.getText();
            String empId = empIdField.getText();
            Task task = findTaskById(taskId);
            Employee employee = findEmployeeById(empId);
            if (task != null && employee != null) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Log Time");
                dialog.setHeaderText(null);
                dialog.setContentText("Enter hours:");
                dialog.showAndWait().ifPresent(hours -> task.logTime(employee, Integer.parseInt(hours)));
                updateTasks();
                empIdField.clear();
            }
        });

        TableView<Task> table = new TableView<>(tasks);

        TableColumn<Task, String> idColumn = new TableColumn<>("Task ID");
        idColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));

        TableColumn<Task, String> descColumn = new TableColumn<>("Task Description");
        descColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));

        TableColumn<Task, String> empColumn = new TableColumn<>("Assigned Employee");
        empColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAssignedEmployee() != null ? data.getValue().getAssignedEmployee().getName() : "Unassigned"));

        table.getColumns().addAll(idColumn, descColumn, empColumn);

        vbox.getChildren().addAll(new Label("Manage Tasks"), taskIdField, taskDescField, projIdField, empIdField, addButton, assignButton, logTimeButton, table);
        return vbox;
    }

    private VBox createReportsTab() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        TableView<Project> table = new TableView<>(projects);

        TableColumn<Project, String> nameColumn = new TableColumn<>("Project Name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Project, String> timeColumn = new TableColumn<>("Total Time Spent");
        timeColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getTotalTimeSpent())));

        table.getColumns().addAll(nameColumn, timeColumn);

        vbox.getChildren().addAll(new Label("Project Reports"), table);
        return vbox;
    }

    private Employee findEmployeeById(String id) {
        for (Employee e : department.getEmployees()) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    private Project findProjectById(String id) {
        for (Project p : department.getProjects()) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    private Task findTaskById(String id) {
        for (Project p : department.getProjects()) {
            for (Task t : p.getTasks()) {
                if (t.getId().equals(id)) {
                    return t;
                }
            }
        }
        return null;
    }

    private void updateTasks() {
        tasks.clear();
        department.getProjects().forEach(project -> tasks.addAll(project.getTasks()));
    }
}