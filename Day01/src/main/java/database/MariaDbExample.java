package database;

import java.sql.*;

public class MariaDbExample {


    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/java", "java", "QweAsdZxc!23"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                System.out.print(resultSet.getString("id"));
                System.out.print("\t");
                System.out.println(resultSet.getString("email"));
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
