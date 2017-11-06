package model.resultObjects;

import model.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class ResAircraft {
    private int idAircraft;
    private String name;
    private int passengers;
    private int maxWeightKg;
    private int maxRangeKm;

    private ResAircraft(int idAircraft, String name, int passengers, int maxWeightKg, int maxRangeKm) {
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


    @Override
    public int hashCode() {
        return Objects.hash( idAircraft, name, passengers, maxWeightKg, maxRangeKm );
    }


    public static List<ResAircraft> selectAll (Connection conn){

        List <ResAircraft> result = new ArrayList <>();

        try ( Statement st = conn.createStatement();
              ResultSet res = st.executeQuery(Constants.SELECT_ALL_AIRCRAFTS)) {
            while (res.next()) {
                result.add ( new ResAircraft(
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
