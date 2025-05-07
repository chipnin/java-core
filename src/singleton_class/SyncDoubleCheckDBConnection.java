package singleton_class;

/**
 * Synchronized initialization with double check (Multi threads)
 * involves creating the Singleton instance when the class is loaded
 */
public class SyncDoubleCheckDBConnection {
    private static volatile SyncDoubleCheckDBConnection instance;
    private SyncDoubleCheckDBConnection() {
    }

    public static SyncDoubleCheckDBConnection getInstance() {
        if (instance == null) {
            synchronized (SyncDoubleCheckDBConnection.class) {
                if (instance == null) {
                    instance = new SyncDoubleCheckDBConnection();
                }
            }
        }
        return instance;
    }

    public void syncDB() {}
}
