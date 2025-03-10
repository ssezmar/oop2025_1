public interface NotificationFactory {
    Notification createNotification();
}

// filepath: /home/ssezmar/programming/University/oop/task4/EmailNotificationFactory.java
public class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

// filepath: /home/ssezmar/programming/University/oop/task4/SMSNotificationFactory.java
public class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

// filepath: /home/ssezmar/programming/University/oop/task4/PushNotificationFactory.java
public class PushNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}