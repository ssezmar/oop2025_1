public class DiscountedOrder<T> extends Order<T> {
    private double discountPercent;

    public DiscountedOrder(T item, int quantity, double discountPercent) {
        super(item, quantity);
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double getTotalPrice() {
        Product product = (Product) getItem();
        double totalPrice = product.getPrice() * getQuantity();
        return totalPrice - (totalPrice * discountPercent / 100);
    }
}