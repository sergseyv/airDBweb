package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class entityAircraft {
    private int idAircraft;
    private String name;
    private int passengers;
    private int maxWeightKg;
    private int maxRangeKm;

    private entityAircraft (int idAircraft, String name, int passengers, int maxWeightKg, int maxRangeKm) {
        this.idAircraft = idAircraft;
        this.name = name;
        this.passengers = passengers;
        this.maxWeightKg = maxWeightKg;
        this.maxRangeKm = maxRangeKm;
    }

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


    public static List<entityAircraft> selectAll (Connection conn){

        ArrayList <entityAircraft> result = new ArrayList <>();

        try ( Statement st = conn.createStatement();
              ResultSet res = st.executeQuery(Constants.SELECT_ALL_AIRCRAFTS)) {
            while (res.next()) {
                result.add ( new entityAircraft(
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


}
