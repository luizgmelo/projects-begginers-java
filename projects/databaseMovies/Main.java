package databaseMovies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String query = "SELECT * FROM movies";
        try (Connection connection = MoviesDB.connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int year = resultSet.getInt("year");
                String director = resultSet.getString("director");
                System.out.println(id+" "+title+" "+year+" "+director);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
