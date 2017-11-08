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
    private static void addAircraft (PreparedStatement pst, String name,
                                     int passengers, int max_weight, int max_range){
        try {

            pst.setString(1, name);
            pst.setInt(2, passengers);
            pst.setInt(3, max_weight);
            pst.setInt(4, max_range);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addAircrafts (Connection conn) {
        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_AIRCRAFTS);
            addAircraft(pst, "Airbus A319", 156, 75000, 6850);
            addAircraft(pst, "Airbus A320", 180, 77000, 6150);
            addAircraft(pst, "Airbus A321", 220, 93500, 5950);
            addAircraft(pst, "Airbus A330", 335, 233000, 10800);
            addAircraft(pst, "Airbus A350", 440, 268000, 15000);
            addAircraft(pst, "Airbus A380", 525, 560000, 12000);
            addAircraft(pst, "Boeing 737-500", 132, 52390, 5200);
            addAircraft(pst, "Boeing 747-400ER", 524, 412000, 14205);
            addAircraft(pst, "Boeing 767-200ER", 255, 179000, 12200);
            addAircraft(pst, "Boeing 777-200ER", 400, 297560, 14260);
            addAircraft(pst, "Boeing 787 Dreamliner", 290, 254000, 14140);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* ========================================================================== */


    /* заполняем таблицу авиакомпаний =========================================== */
    private static void addCompanie (PreparedStatement pst, String name, String country){
        try {

            pst.setString(1, name);
            pst.setString(2, country);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addCompanies (Connection conn) {
        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_COMPANIES);
            addCompanie(pst, "Emirates", "United Arab Emirates");
            addCompanie(pst, "Air China", "China");
            addCompanie(pst, "All Nippon Airways", "Japan");
            addCompanie(pst, "Jet Airways", "India");
            addCompanie(pst, "Aeroflot", "Russian Federation");
            addCompanie(pst, "Lufthansa", "Germany");
            addCompanie(pst, "American Airlines", "USA");
            addCompanie(pst, "Alitalia", "Italy");
            addCompanie(pst, "Ryanair", "Ireland");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* ========================================================================== */


    /* заполняем таблицу отношений "Компания - самолеты" ======================== */
    private static void addOwnership (PreparedStatement pst, int id_companies,
                                      int id_aircraft, int quantity){
        try {

            pst.setInt(1, id_companies);
            pst.setInt(2, id_aircraft);
            pst.setInt(3, quantity);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addOwnerships (Connection conn) {
        try {
            PreparedStatement pst = conn.prepareStatement(Constants.ADD_OWNERSHIP);
            addOwnership(pst,1, 6, 23);
            addOwnership(pst,1, 8, 45);
            addOwnership(pst,1, 10, 11);
            addOwnership(pst,1, 11, 7);
            addOwnership(pst,2, 3, 73);
            addOwnership(pst,2, 10, 52);
            addOwnership(pst,2, 5, 18);
            addOwnership(pst,3, 4, 21);
            addOwnership(pst,3, 8, 38);
            addOwnership(pst, 3, 9, 41);
            addOwnership(pst, 4, 9, 73);
            addOwnership(pst, 4, 4, 43);
            addOwnership(pst, 5, 1, 28);
            addOwnership(pst, 5, 2, 36);
            addOwnership(pst, 5, 4, 41);
            addOwnership(pst, 5, 8, 56);
            addOwnership(pst, 6, 7, 57);
            addOwnership(pst, 6, 3, 19);
            addOwnership(pst, 6, 11, 33);
            addOwnership(pst, 7, 3, 68);
            addOwnership(pst, 7, 5, 72);
            addOwnership(pst, 7, 8, 45);
            addOwnership(pst, 7, 9, 24);
            addOwnership(pst, 8, 6, 37);
            addOwnership(pst, 8, 1, 34);
            addOwnership(pst, 8, 7, 45);
            addOwnership(pst, 9, 2, 43);
            addOwnership(pst, 9, 7, 15);
            addOwnership(pst, 9, 11, 29);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* ========================================================================== */

}
