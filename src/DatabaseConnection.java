import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/TWStremaingX";
    private static final String USER = "TWStesteAdm";
    private static final String PASSWORD = "ADM123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
// Precisa decidir se vai rodar no azure ou local para definir IP do servidor.
// Alterar dados de login banco