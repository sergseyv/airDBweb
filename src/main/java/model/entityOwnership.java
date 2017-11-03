package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class entityOwnership {
    private int idOwnership;
    private int idCompany;
    private int idAircraft;
    private int quantity;

    private entityOwnership(int idOwnership, int idCompany, int idAircraft, int quantity) {
        this.idOwnership = idOwnership;
        this.idCompany = idCompany;
        this.idAircraft = idAircraft;
        this.quantity = quantity;
    }

    public int getIdOwnership() {
        return idOwnership;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public int getIdAircraft() {
        return idAircraft;
    }

    public int getQuantity() {
        return quantity;
    }

    public static List<entityOwnership> selectAll (Connection conn){

        List <entityOwnership> result = new ArrayList <>();

        try ( Statement st = conn.createStatement();
              ResultSet res = st.executeQuery(Constants.SELECT_ALL_OWNERSHIPS)) {
            while (res.next()) {
                result.add ( new entityOwnership (
                        res.getInt("id_ownership"),
                        res.getInt("id_companies"),
                        res.getInt("id_aircraft"),
                        res.getInt("quantity"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


}
