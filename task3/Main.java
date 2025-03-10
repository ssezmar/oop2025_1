public class Main {
    public static void main(String[] args) {
        Electronics laptop = new Electronics("Ноутбук", 1200.00, 24);
        Clothing shirt = new Clothing("Рубашка", 50.00, "L");

        Order<Electronics> laptopOrder = new Order<>(laptop, 2);
        Order<Clothing> shirtOrder = new Order<>(shirt, 5);

        DiscountedOrder<Electronics> discountedLaptopOrder = new DiscountedOrder<>(laptop, 1, 10);

        laptop.printInfo();
        shirt.printInfo();

        System.out.println("Общая стоимость заказа на ноутбуки: " + laptopOrder.getTotalPrice());
        System.out.println("Общая стоимость заказа на рубашки: " + shirtOrder.getTotalPrice());
        System.out.println("Общая стоимость заказа на ноутбук со скидкой: " + discountedLaptopOrder.getTotalPrice());
    }
}