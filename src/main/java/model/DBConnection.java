package model;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.*;


/**
 * Created by Seyvach Serg on 31.10.2017.
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/aero_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "15426";

    private static DBConnection dbConnection = null;
    private Connection conn;

    private DBConnection() {
        try {
            Driver drv = new FabricMySQLDriver();
            DriverManager.registerDriver(drv);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getIstance(){
        return ( dbConnection == null ) ? new DBConnection() : dbConnection;
    }

    public Connection getConnection(){
        //TODO use connection pull?
        return conn; //TODO We should keep connection for current session?
    }

    public void closeConnection() throws SQLException{
        if(conn !=null) {
            conn.close();
        }
    }
}