import singleton_class.DBConnectionEnum;

import java.sql.Connection;

public class Student {
    public static void main(String[] args) throws Exception {
        float var1 = 0.3f;
        float var2 = 0.1f;
        float var3 = var1 - var2;
        System.out.println(var3);
        System.out.println(Employee.FIRST_ID);

//        Connection conn = DBConnectionEnum.INSTANCE.getConnection();
//        System.out.println("Using connection" + conn);
//        DBConnectionEnum.INSTANCE.closeConnection();

        try {
            Number a = 8/0;
            System.out.println("a = " + a);
            return;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e);
            return;
        }
        catch (Exception e) {
            System.out.println("Go Exception: " + e);
        } finally {
            System.out.println("Finally block");
        }

        System.out.println("End block");
    }
}
