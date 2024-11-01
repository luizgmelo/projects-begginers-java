package databaseMovies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MoviesDB {
    public static Connection connect() throws SQLException {
        String jdbcUrl = DatabaseConfig.getDbUrl();
        String jdbcUsername = DatabaseConfig.getDbUsername();
        String jdbcPassword = DatabaseConfig.getDbPassword();

        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }
}
