public class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void printInfo() {
        System.out.println("Clothing: " + getName() + ", Price: " + getPrice() + ", Size: " + size);
    }
}