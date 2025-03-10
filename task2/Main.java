import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вариант 1\n\n");
        List<Employee> employees = new ArrayList<>();

        employees.add(new Developer("Alice", 5, 1000));
        employees.add(new Manager("Bob", 10, 1500));

        employees.add(new Employee() {
            @Override
            public void work() {
                System.out.println("Выполняю временные задачи");
            }

            @Override
            public double getSalary() {
                return 50000;
            }
        });

        employees.add(new Employee() {
            @Override
            public void work() {
                System.out.println("Работаю как фрилансер");
            }

            @Override
            public double getSalary() {
                return 60000;
            }
        });

        for (Employee employee : employees) {
            employee.work();
            System.out.println("Зарплата: " + employee.getSalary());

            if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                System.out.println("Бонус: " + manager.calculateBonus());
            }
        }
    }
}