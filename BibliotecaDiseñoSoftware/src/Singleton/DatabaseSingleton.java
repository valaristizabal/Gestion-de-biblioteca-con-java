/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sotog
 */
public class DatabaseSingleton {

    private static DatabaseSingleton instance;
    private Connection connection;

    private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/";
    private static final String DATABASE_NAME = "db_bibliotecas"; // Replace with your database name
    private static final String USUARIO = "root";
    private final String PASSWORD = "";

    private DatabaseSingleton() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL + DATABASE_NAME, USUARIO, PASSWORD);

            // Select the database
            String useDatabaseSQL = "USE " + DATABASE_NAME;
            try ( Statement statement = connection.createStatement()) {
                statement.execute(useDatabaseSQL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
