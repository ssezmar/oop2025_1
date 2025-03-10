public class MainSingletonDemo {
    public static void main(String[] args) {
        // Get the single instance of DatabaseConnection and connect
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        connection1.connect();

        // Get the single instance of DatabaseConnection from another place and connect
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        connection2.connect();

        // Disconnect from the database
        connection1.disconnect();
    }
}