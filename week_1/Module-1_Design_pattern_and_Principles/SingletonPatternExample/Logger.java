/**
 * Logger class implementing the Singleton Design Pattern.
 * This class ensures that only one instance of the logger exists throughout the application lifecycle.
 */
public class Logger {
    // 1. Private static instance of the class (volatile for thread-safety during double-checked locking)
    private static volatile Logger instance;

    // 2. Private constructor to prevent instantiation from other classes
    private Logger() {
        // Prevent instantiation via reflection
        if (instance != null) {
            throw new IllegalStateException("Logger instance already created.");
        }
    }

    // 3. Public static method to provide the global point of access to the instance
    public static Logger getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Logger.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * Log a message to the console.
     * @param message The message to log.
     */
    public void log(String message) {
        System.out.println("[LOG] " + java.time.LocalDateTime.now() + " : " + message);
    }
}
