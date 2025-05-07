package singleton_class;

/**
 * Eager initialization
 * involves creating the Singleton instance when the class is loaded
 */
public class EagerDBConnection {
    private static EagerDBConnection instance = new EagerDBConnection();
    private EagerDBConnection() {
    }

    public static EagerDBConnection getInstance() {
        return instance;
    }
}
