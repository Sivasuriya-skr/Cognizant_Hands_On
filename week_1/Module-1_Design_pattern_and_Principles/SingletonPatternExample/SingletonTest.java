/**
 * Test class to verify the Singleton implementation of the Logger.
 */
public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern (Logger) ===");

        // Get two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Print hash codes to verify they are the same instance
        System.out.println("Logger Instance 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger Instance 2 HashCode: " + logger2.hashCode());

        // Verify they are the same instance
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both instances are identical. Logger follows the Singleton Pattern!");
        } else {
            System.out.println("FAILURE: Logger instances are different. Singleton Pattern violated!");
        }

        // Test logging functionality
        logger1.log("This is a log message from logger1.");
        logger2.log("This is a log message from logger2.");

        // Additional: Test thread-safety to prove the double-checked locking works
        System.out.println("\n=== Testing Thread-Safety of Logger ===");
        Runnable task = () -> {
            Logger threadLogger = Logger.getInstance();
            System.out.println("Thread " + Thread.currentThread().getName() + " got instance: " + threadLogger.hashCode());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.err.println("Thread verification interrupted: " + e.getMessage());
        }

        System.out.println("=== Singleton Test Completed ===");
    }
}
