package model.mainObjects;

import model.Constants;
import model.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class Aircraft {

    private int idAircraft;
    private String name;
    private int passengers;
    private int maxWeightKg;
    private int maxRangeKm;

    public Aircraft(int idAircraft, String name, int passengers, int maxWeightKg, int maxRangeKm) {
        this.idAircraft = idAircraft;
        this.name = name;
        this.passengers = passengers;
        this.maxWeightKg = maxWeightKg;
        this.maxRangeKm = maxRangeKm;
    }

    public Aircraft(String name, int passengers, int maxWeightKg, int maxRangeKm) {
        this.name = name;
        this.passengers = passengers;
        this.maxWeightKg = maxWeightKg;
        this.maxRangeKm = maxRangeKm;
    }

    public Aircraft(){}


    public int getIdAircraft() {
        return idAircraft;
    }

    public String getName() {
        return name;
    }

    public int getPassengers() {
        return passengers;
    }

    public int getMaxWeightKg() {
        return maxWeightKg;
    }

    public int getMaxRangeKm() {
        return maxRangeKm;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setMaxWeightKg(int maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }

    public void setMaxRangeKm(int maxRangeKm) {
        this.maxRangeKm = maxRangeKm;
    }


    @Override
    public int hashCode() {
        return Objects.hash( idAircraft, name, passengers, maxWeightKg, maxRangeKm );
    }


    // "SELECT * from aircrafts"   в список ArrayList
    public static List<Aircraft> selectAll (Connection conn){

        List <Aircraft> result = new ArrayList <>();

        try ( Statement st = conn.createStatement();
              ResultSet res = st.executeQuery(Constants.SELECT_ALL_AIRCRAFTS)) {
            while (res.next()) {
                result.add ( new Aircraft(
                        res.getInt("id_aircraft"),
                        res.getString("name"),
                        res.getInt("passengers"),
                        res.getInt("max_weight__kg"),
                        res.getInt("max_range__km"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }




    //  Добавление Aircraft,  3 варианта параметров

    public static void add( Aircraft aircraft ) {
        Connection conn = DBConnection.getIstance().getConnection();
        add(conn, aircraft);
    }

    public static void add( Connection conn, Aircraft aircraft ) {
        try (PreparedStatement pst = conn.prepareStatement(Constants.ADD_AIRCRAFTS)) {
            add (pst, aircraft);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add( PreparedStatement pst, Aircraft aircraft ) {
        try {
            pst.setString(1, aircraft.name);
            pst.setInt(2, aircraft.passengers);
            pst.setInt(3, aircraft.maxWeightKg);
            pst.setInt(4, aircraft.maxRangeKm);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}