package model;

import model.mainObjects.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DbWork {

    public static void restoreDb(){
        initializeDB();
        addAircrafts();
        addCompanies();
        addOwnerships();
    }


    public static void doQuery (String sql){
        Connection conn = DbConnection.getIstance().getConnection();
        doQuery(conn, sql);
        DbConnection.getIstance().closeConnection(conn);
    }

    private static void doQuery(Connection conn, String sql){
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /* пересоздаем таблицы (дропаем старые, если они есть и создаем заново) ======*/
    private static void initializeDB(){
        doQuery(Constants.DROP_AIRCRAFTS);
        doQuery(Constants.DROP_COMPANIES);
        doQuery(Constants.DROP_OWNERSHIP);
        doQuery(Constants.CREATE_AIRCRAFTS);
        doQuery(Constants.CREATE_COMPANIES);
        doQuery(Constants.CREATE_OWNERSHIP);
    }


    /* заполняем таблицу самолетов ============================================== */

    private static void addAircrafts() {

        Connection conn = DbConnection.getIstance().getConnection();

        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_AIRCRAFTS);
            Aircraft.add ( pst, new Aircraft("Airbus A319", 156, 75000, 6850 ) );
            Aircraft.add ( pst, new Aircraft("Airbus A320", 180, 77000, 6150 ) );
            Aircraft.add ( pst, new Aircraft("Airbus A321", 220, 93500, 5950 ) );
            Aircraft.add ( pst, new Aircraft("Airbus A330", 335, 233000, 10800 ) );
            Aircraft.add ( pst, new Aircraft("Airbus A350", 440, 268000, 15000 ) );
            Aircraft.add ( pst, new Aircraft("Airbus A380", 525, 560000, 12000 ) );
            Aircraft.add ( pst, new Aircraft("Boeing 737-500", 132, 52390, 5200 ) );
            Aircraft.add ( pst, new Aircraft("Boeing 747-400ER", 524, 412000, 14205 ) );
            Aircraft.add ( pst, new Aircraft("Boeing 767-200ER", 255, 179000, 12200 ) );
            Aircraft.add ( pst, new Aircraft("Boeing 777-200ER", 400, 297560, 14260 ) );
            Aircraft.add ( pst, new Aircraft("Boeing 787 Dreamliner", 290, 254000, 14140 ) );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DbConnection.getIstance().closeConnection(conn);
    }



    /* заполняем таблицу авиакомпаний =========================================== */

    private static void addCompanies() {

        Connection conn = DbConnection.getIstance().getConnection();

        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_COMPANIES);
            Company.add(pst, new Company("Emirates", "United Arab Emirates"));
            Company.add(pst, new Company("Air China", "China"));
            Company.add(pst, new Company("All Nippon Airways", "Japan"));
            Company.add(pst, new Company("Jet Airways", "India"));
            Company.add(pst, new Company("Aeroflot", "Russian Federation"));
            Company.add(pst, new Company("Lufthansa", "Germany"));
            Company.add(pst, new Company("American Airlines", "USA"));
            Company.add(pst, new Company("Alitalia", "Italy"));
            Company.add(pst, new Company("Ryanair", "Ireland"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DbConnection.getIstance().closeConnection(conn);
    }



    /* заполняем таблицу отношений "Компания - самолеты" ======================== */

    private static void addOwnerships() {

        Connection conn = DbConnection.getIstance().getConnection();

        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_OWNERSHIP);
            Ownership.add(pst, new Ownership(1, 6, 23));
            Ownership.add(pst, new Ownership(1, 8, 45));
            Ownership.add(pst, new Ownership(1, 10, 11));
            Ownership.add(pst, new Ownership(1, 11, 7));
            Ownership.add(pst, new Ownership(2, 3, 73));
            Ownership.add(pst, new Ownership(2, 10, 52));
            Ownership.add(pst, new Ownership(2, 5, 18));
            Ownership.add(pst, new Ownership(3, 4, 21));
            Ownership.add(pst, new Ownership(3, 8, 38));
            Ownership.add(pst, new Ownership(3, 9, 41));
            Ownership.add(pst, new Ownership(4, 9, 73));
            Ownership.add(pst, new Ownership(4, 4, 43));
            Ownership.add(pst, new Ownership(5, 1, 28));
            Ownership.add(pst, new Ownership(5, 2, 36));
            Ownership.add(pst, new Ownership(5, 4, 41));
            Ownership.add(pst, new Ownership(5, 8, 56));
            Ownership.add(pst, new Ownership(6, 7, 57));
            Ownership.add(pst, new Ownership(6, 3, 19));
            Ownership.add(pst, new Ownership(6, 11, 33));
            Ownership.add(pst, new Ownership(7, 3, 68));
            Ownership.add(pst, new Ownership(7, 5, 72));
            Ownership.add(pst, new Ownership(7, 8, 45));
            Ownership.add(pst, new Ownership(7, 9, 24));
            Ownership.add(pst, new Ownership(8, 6, 37));
            Ownership.add(pst, new Ownership(8, 1, 34));
            Ownership.add(pst, new Ownership(8, 7, 45));
            Ownership.add(pst, new Ownership(9, 2, 43));
            Ownership.add(pst, new Ownership(9, 7, 15));
            Ownership.add(pst, new Ownership(9, 11, 29));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DbConnection.getIstance().closeConnection(conn);
    }

}
