public class Main {
    public static void main(String[] args) {

        System.out.println("Вариант 5\n\n");

        Employee emp = new Employee("John Doe", "Software Engineer", 4500.00);

        
        emp.displayInfo();

        
        emp.changeSalary(5500.00);
        System.out.println("\nAfter changing salary:");
        emp.displayInfo();

        
        emp.increaseSalary(500.00);
        System.out.println("\nAfter increasing salary:");
        emp.displayInfo();

        
        emp.decreaseSalary(1000.00);
        System.out.println("\nAfter decreasing salary:");
        emp.displayInfo();

        
        System.out.println("\nIs the salary high? " + emp.isHighSalary());

        
        System.out.println("\nCurrent position: " + emp.getPosition());
        emp.updatePosition("Senior Software Engineer");
        System.out.println("Position after update: " + emp.getPosition());

        
        System.out.println("\nEmployee information: " + emp.getEmployeeInfo());
    }
}

class Employee {
    private String name;
    private String position;
    private double salary;

    
    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    
    public void changeSalary(double newSalary) {
        this.salary = newSalary;
    }

    
    public void increaseSalary(double amount) {
        this.salary += amount;
    }

    
    public void decreaseSalary(double amount) {
        if(this.salary - amount >= 0) {
            this.salary -= amount;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    
    public boolean isHighSalary() {
        return this.salary > 5000;
    }

    
    public String getPosition() {
        return this.position;
    }

    
    public void updatePosition(String newPosition) {
        this.position = newPosition;
    }

    
    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Position: " + this.position);
        System.out.println("Salary: " + this.salary);
    }

    
    public String getEmployeeInfo() {
        return "Name: " + this.name + ", Position: " + this.position + ", Salary: " + this.salary;
    }
}