public class DatabaseConnection {
    // Volatile variable to ensure visibility of changes across threads
    private static volatile DatabaseConnection instance;
    private boolean connected;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
    }

    // Method to get the single instance of DatabaseConnection
    public static DatabaseConnection getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (DatabaseConnection.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Method to connect to the database
    public void connect() {
        if (!connected) {
            connected = true;
            System.out.println("Database connection established.");
        }
    }

    // Method to disconnect from the database
    public void disconnect() {
        if (connected) {
            connected = false;
            System.out.println("Database connection closed.");
        }
    }
}