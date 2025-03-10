class Developer extends AbstractEmployee {
    
    public Developer(String name, int experience, double baseSalary) {
        super(name, experience, baseSalary);
    }

    @Override
    public void work() {
        System.out.println("Разрабатываю программное обеспечение");
    }
}