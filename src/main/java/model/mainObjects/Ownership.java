package model.mainObjects;

import model.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class Ownership {
    private int idOwnership;
    private int idCompany;
    private int idAircraft;
    private int quantity;

    private Ownership(int idOwnership, int idCompany, int idAircraft, int quantity) {
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


    @Override
    public int hashCode() {
        return Objects.hash( idOwnership, idCompany, idAircraft, quantity);
    }


    public static List<Ownership> selectAll (Connection conn){

        List <Ownership> result = new ArrayList <>();

        try ( Statement st = conn.createStatement();
              ResultSet res = st.executeQuery(Constants.SELECT_ALL_OWNERSHIPS)) {
            while (res.next()) {
                result.add ( new Ownership(
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
