package model;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/aero_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "15426";
    private static DbConnection dbconnection = null;
    private Connection conn = null;
    private ComboPooledDataSource poolDS = null;

    private DbConnection() {

        poolDS = new ComboPooledDataSource();

        try {
            poolDS.setDriverClass( "com.mysql.jdbc.Driver" );
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        poolDS.setJdbcUrl(URL);
        poolDS.setUser(USERNAME);
        poolDS.setPassword(PASSWORD );
        poolDS.setMaxStatements(180);
        poolDS.setMaxStatementsPerConnection(20);
        poolDS.setMinPoolSize(1);
        poolDS.setAcquireIncrement(1);
        poolDS.setMaxPoolSize(20);
    }


    public static synchronized DbConnection getIstance(){
        if ( dbconnection == null ) {
            dbconnection = new DbConnection();
        }
        return dbconnection;
    }


    public Connection getConnection(){
        try {
            conn = poolDS.getConnection();
            conn.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}