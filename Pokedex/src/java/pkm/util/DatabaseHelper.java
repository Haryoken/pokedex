/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DUCVINH
 */
public class DatabaseHelper {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String DBStr = "jdbc:sqlserver://localhost;databaseName=PokemonDB";
        String user = "sa";
        String password = "zodiacaries1104";
        connection = DriverManager.getConnection(DBStr, user, password);
        return connection;
    }

}
