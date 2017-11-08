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

    public Ownership(int idCompany, int idAircraft, int quantity) {
        this.idCompany = idCompany;
        this.idAircraft = idAircraft;
        this.quantity = quantity;
    }

    public Ownership() {}

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

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public void setIdAircraft(int idAircraft) {
        this.idAircraft = idAircraft;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash( idOwnership, idCompany, idAircraft, quantity);
    }


    // "SELECT * from ownerships"   в список ArrayList
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


    //  Добавление Ownership,  3 варианта параметров

    public static void add( Ownership ownership ) {
        Connection conn = DBConnection.getIstance().getConnection();
        add(conn, ownership);
    }

    public static void add( Connection conn, Ownership ownership ) {
        try (PreparedStatement pst = conn.prepareStatement(Constants.ADD_OWNERSHIP)) {
            add (pst, ownership);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add( PreparedStatement pst, Ownership ownership ) {
        try {
            pst.setInt(1, ownership.idCompany);
            pst.setInt(2, ownership.idAircraft);
            pst.setInt(3, ownership.quantity);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
