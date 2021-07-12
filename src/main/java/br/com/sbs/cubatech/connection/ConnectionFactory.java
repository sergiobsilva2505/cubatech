package br.com.sbs.cubatech.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recoverConnection() throws SQLException {
        String urlDatabase = "jdbc:mysql://localhost/cubatechDb?useTimezone=true&serverTimezone=UTC";
        String  user = "root";
        String password = "Alura@123";

        Connection connection= DriverManager.getConnection(urlDatabase, user, password);
        return  connection;
    }
}
