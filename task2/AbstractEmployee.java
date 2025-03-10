abstract class AbstractEmployee implements Employee {
    String name;
    int experience;
    double baseSalary;

    public AbstractEmployee(String name, int experience, double baseSalary) {
        this.name = name;
        this.experience = experience;
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary() {
        return baseSalary * experience;
    }

    @Override
    public abstract void work();
}