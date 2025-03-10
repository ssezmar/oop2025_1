import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Singleton demonstration
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        connection1.connect();

        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        connection2.connect();

        // Factory Method demonstration
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter notification type (email, sms, push): ");
        String type = scanner.nextLine();

        NotificationFactory factory = new NotificationFactory();
        Notification notification = factory.createNotification(type);
        notification.send("This is a test message.");
    }
}