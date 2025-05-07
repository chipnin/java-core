package singleton_class;

/**
 * Synchronized initialization (Multi threads)
 */
public class SyncDBConnection {
    private static SyncDBConnection instance;
    private SyncDBConnection() {
    }

    synchronized public static SyncDBConnection getInstance() {
        if (instance == null) {
            instance = new SyncDBConnection();
        }
        return instance;
    }
}
