package singleton_class;

/**
 * Eager initialization with static inner class (best implement singleton)
 * involves creating the Singleton instance when the class inner class is loaded
 */
public class EagerWithStaticInnerClassDBConnection {
    private EagerWithStaticInnerClassDBConnection() {
    }

    private static class DbConnectionHolder {
        private static final EagerWithStaticInnerClassDBConnection INSTANCE = new EagerWithStaticInnerClassDBConnection();
    }

    public static EagerWithStaticInnerClassDBConnection getInstance() {
        return DbConnectionHolder.INSTANCE;
    }

    public void syncDB() {}
}
