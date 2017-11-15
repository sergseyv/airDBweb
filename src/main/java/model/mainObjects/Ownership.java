package model.mainObjects;

import model.Constants;
import model.DbConnection;
import model.DbWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public void setIdOwnership(int idOwnership) {
        this.idOwnership = idOwnership;
    }


    // "SELECT * from ownerships"   в список ArrayList
    public static List<Ownership> selectAll(){

        Connection conn = DbConnection.getIstance().getConnection();
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

        DbConnection.getIstance().closeConnection(conn);

        return result;
    }


    public static void add( Ownership ownership ) {
        Connection conn = DbConnection.getIstance().getConnection();
        add(conn, ownership);
        DbConnection.getIstance().closeConnection(conn);
    }

    public static void add( Connection conn, Ownership ownership ) {
        try (PreparedStatement pst = conn.prepareStatement(Constants.ADD_OWNERSHIP)) {
            add (pst, ownership);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // добавление новой записи в БД
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


    // Изменение значения Ownership в таблице, по ID
    public static void upd ( Ownership ownership ) {

        int idOwnership = ownership.getIdOwnership();
        int idCompany = ownership.getIdCompany();
        int idAircraft = ownership.getIdAircraft();
        int quantity = ownership.getQuantity();

        /*
        Если пришло хотя бы одно ненулевое значение, составялем SQL-запрос
        на UPDATE ненулевых полей
         */
        if ( ( idCompany >= 0 ) || ( idAircraft >= 0 ) || ( quantity >= 0 ) ) {

            StringBuilder query = new StringBuilder("UPDATE ownership SET ");

            if ( idCompany >= 0 )
                query.append("id_companies = ").append(idCompany).append(", ");
            if ( idAircraft >= 0 )
                query.append("id_aircraft = ").append(idAircraft).append(", ");
            if ( quantity >= 0 )
                query.append("quantity = ").append(quantity).append(", ");

            query.deleteCharAt(query.length()-2);   // удаляем последнюю запятую

            query.append("WHERE id_ownership = ").append(idOwnership).append(";");

            DbWork.doQuery( query.toString() );
        }
    }


    // Удаление одной записи Ownership в таблице, по ID
    public static void del ( String id ){

        DbWork.doQuery ( "DELETE FROM ownership WHERE id_ownership =" + id );
    }

}
