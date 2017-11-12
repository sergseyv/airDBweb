package model;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;


/**
 * Created by Seyvach Serg on 31.10.2017.
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/aero_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "15426";
    private static DBConnection dbConnection = null;
    private Connection conn = null;

    private DBConnection() {}

    public static synchronized DBConnection getIstance(){
        if ( dbConnection == null ) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }


    public Connection getConnection(){
        if ( conn == null ) {
            try {
                Driver drv = new FabricMySQLDriver();
                DriverManager.registerDriver(drv);
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                conn.setAutoCommit(true);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    public void closeConnection() {
        if (conn !=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}