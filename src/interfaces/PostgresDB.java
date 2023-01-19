package interfaces;
import java.sql.*;
import java.sql.DriverManager;

public class PostgresDB implements IDB{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/myDb";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "gazizorda101");
            System.out.println("connected");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Здесь");
            return null;
        }
    }
}
