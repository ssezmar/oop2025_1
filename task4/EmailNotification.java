public interface Notification {
    void send(String message);
}

// filepath: /home/ssezmar/programming/University/oop/task4/EmailNotification.java
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

// filepath: /home/ssezmar/programming/University/oop/task4/SMSNotification.java
public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

// filepath: /home/ssezmar/programming/University/oop/task4/PushNotification.java
public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Push notification sent: " + message);
    }
}