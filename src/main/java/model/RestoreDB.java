package model;

import java.sql.*;
/**
 * Created by Seyvach Serg on 23.10.2017.
 */
public class RestoreDB {

    public static void restore(Connection conn){
        initializeDB (conn);
        addAircrafts (conn);
        addCompanies (conn);
        addOwnerships (conn);
    }


    /* пересоздаем таблицы (дропаем старые, если они есть и создаем заново) ======*/
    private static void doQuery(Connection conn, String sql){
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void initializeDB(Connection conn){
        doQuery(conn, Constants.DROP_AIRCRAFTS);
        doQuery(conn, Constants.DROP_COMPANIES);
        doQuery(conn, Constants.DROP_OWNERSHIP);
        doQuery(conn, Constants.CREATE_AIRCRAFTS);
        doQuery(conn, Constants.CREATE_COMPANIES);
        doQuery(conn, Constants.CREATE_OWNERSHIP);
    }
    /* ========================================================================== */


    /* заполняем таблицу самолетов ============================================== */
    private static void addAircraft (PreparedStatement pst, int id, String name,
                                     int passengers, int max_weight, int max_range){
        try {
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, passengers);
            pst.setInt(4, max_weight);
            pst.setInt(5, max_range);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addAircrafts (Connection conn) {
        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_AIRCRAFTS);
            addAircraft(pst, 1,"Airbus A319", 156, 75000, 6850);
            addAircraft(pst, 2,"Airbus A320", 180, 77000, 6150);
            addAircraft(pst, 3,"Airbus A321", 220, 93500, 5950);
            addAircraft(pst, 4,"Airbus A330", 335, 233000, 10800);
            addAircraft(pst, 5,"Airbus A350", 440, 268000, 15000);
            addAircraft(pst, 6,"Airbus A380", 525, 560000, 12000);
            addAircraft(pst, 7,"Boeing 737-500", 132, 52390, 5200);
            addAircraft(pst, 8,"Boeing 747-400ER", 524, 412000, 14205);
            addAircraft(pst, 9,"Boeing 767-200ER", 255, 179000, 12200);
            addAircraft(pst, 10,"Boeing 777-200ER", 400, 297560, 14260);
            addAircraft(pst, 11,"Boeing 787 Dreamliner", 290, 254000, 14140);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* ========================================================================== */


    /* заполняем таблицу авиакомпаний =========================================== */
    private static void addCompanie (PreparedStatement pst, int id, String name, String country){
        try {
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, country);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addCompanies (Connection conn) {
        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_COMPANIES);
            addCompanie(pst, 1, "Emirates", "United Arab Emirates");
            addCompanie(pst, 2, "Air China", "China");
            addCompanie(pst, 3, "All Nippon Airways", "Japan");
            addCompanie(pst, 4, "Jet Airways", "India");
            addCompanie(pst, 5, "Aeroflot", "Russian Federation");
            addCompanie(pst, 6, "Lufthansa", "Germany");
            addCompanie(pst, 7, "American Airlines", "USA");
            addCompanie(pst, 8, "Alitalia", "Italy");
            addCompanie(pst, 9, "Ryanair", "Ireland");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* ========================================================================== */


    /* заполняем таблицу отношений "Компания - самолеты" ======================== */
    private static void addOwnership (PreparedStatement pst, int id, int id_companies,
                                      int id_aircraft, int quantity){
        try {
            pst.setInt(1, id);
            pst.setInt(2, id_companies);
            pst.setInt(3, id_aircraft);
            pst.setInt(4, quantity);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addOwnerships (Connection conn) {
        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_OWNERSHIP);
            addOwnership(pst, 1, 1, 6, 23);
            addOwnership(pst, 2, 1, 8, 45);
            addOwnership(pst, 3, 1, 10, 11);
            addOwnership(pst, 4, 1, 11, 7);
            addOwnership(pst, 5, 2, 3, 73);
            addOwnership(pst, 6, 2, 10, 52);
            addOwnership(pst, 7, 2, 5, 18);
            addOwnership(pst, 8, 3, 4, 21);
            addOwnership(pst, 9, 3, 8, 38);
            addOwnership(pst, 10, 3, 9, 41);
            addOwnership(pst, 11, 4, 9, 73);
            addOwnership(pst, 12, 4, 4, 43);
            addOwnership(pst, 13, 5, 1, 28);
            addOwnership(pst, 14, 5, 2, 36);
            addOwnership(pst, 15, 5, 4, 41);
            addOwnership(pst, 16, 5, 8, 22);
            addOwnership(pst, 17, 6, 7, 57);
            addOwnership(pst, 18, 6, 3, 19);
            addOwnership(pst, 19, 6, 11, 33);
            addOwnership(pst, 20, 7, 3, 68);
            addOwnership(pst, 21, 7, 5, 72);
            addOwnership(pst, 22, 7, 8, 45);
            addOwnership(pst, 23, 7, 9, 24);
            addOwnership(pst, 24, 8, 6, 37);
            addOwnership(pst, 25, 8, 1, 34);
            addOwnership(pst, 26, 8, 7, 45);
            addOwnership(pst, 27, 9, 2, 43);
            addOwnership(pst, 28, 9, 7, 15);
            addOwnership(pst, 29, 9, 11, 29);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* ========================================================================== */

}
