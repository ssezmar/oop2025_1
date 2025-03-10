class Manager extends AbstractEmployee implements Bonus {

    public Manager(String name, int experience, double baseSalary) {
        super(name, experience, baseSalary);
    }

    @Override
    public void work() {
        System.out.println("Управляю проектами");
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.2;
    }
}