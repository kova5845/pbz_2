import java.sql.*;

public class ParserSQL {
    private static final String user = "root";
    private static final String password = "5845";
    private static final String url = "jdbc:mysql://localhost:3306/insurance?useUnicode=true&serverTimezone=UTC";
    //jdbc:mysql://localhost/db?useUnicode=true&serverTimezone=UTC
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        }
        catch ( ClassNotFoundException e ) {
            System.out.println(e);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
