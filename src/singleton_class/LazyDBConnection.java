package singleton_class;

/**
 * Lazy initialization
 * involves creating the Singleton instance when method getInstance invoke
 */
public class LazyDBConnection {
    private static LazyDBConnection instance;
    private LazyDBConnection() {
    }

    public static LazyDBConnection getInstance() {
        if (instance == null) {
            instance = new LazyDBConnection();
        }
        return instance;
    }
}
