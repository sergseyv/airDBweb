package model.mainObjects;

import model.Constants;
import model.DbConnection;
import model.DbWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public void setIdAircraft(int idAircraft) {
        this.idAircraft = idAircraft;
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


    // "SELECT * from aircrafts"   в список ArrayList
    public static List<Aircraft> selectAll(){

        Connection conn = DbConnection.getIstance().getConnection();

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

        DbConnection.getIstance().closeConnection(conn);

        return result;
    }


    public static void add( Aircraft aircraft ) {
        Connection conn = DbConnection.getIstance().getConnection();
        add(conn, aircraft);
        DbConnection.getIstance().closeConnection(conn);
    }

    public static void add( Connection conn, Aircraft aircraft ) {
        try (PreparedStatement pst = conn.prepareStatement(Constants.ADD_AIRCRAFTS)) {
            add (pst, aircraft);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // добавление новой записи в БД
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


    // Изменение значения Aircraft в таблице, по ID
    public static void upd ( Aircraft aircraft ) {

        int id = aircraft.getIdAircraft();
        String name = aircraft.getName();
        int passengers = aircraft.getPassengers();
        int maxweight = aircraft.getMaxWeightKg();
        int maxrange = aircraft.getMaxRangeKm();

        /*
        Если пришло хотя бы одно ненулевое значение, составялем SQL-запрос
        на UPDATE ненулевых полей
         */
        if ( ( name != null ) || ( passengers >= 0 ) || ( maxweight >= 0 ) || ( maxrange >= 0 ) ) {

            StringBuilder query = new StringBuilder("UPDATE aircrafts SET ");

            if ( name != null )
                query.append("name = '").append(name).append("', ");
            if ( passengers >= 0 )
                query.append("passengers = ").append(passengers).append(", ");
            if ( maxweight >= 0 )
                query.append("max_weight__kg = ").append(maxweight).append(", ");
            if ( maxrange >= 0 )
                query.append("max_range__km = ").append(maxrange).append(", ");

            query.deleteCharAt(query.length()-2);   // удаляем последнюю запятую

            query.append("WHERE id_aircraft = ").append(id).append(";");

            DbWork.doQuery(query.toString());
        }
    }


    // Удаление одной записи Aircraft в таблице, по ID
    public static void del(String id){

        DbWork.doQuery ( "DELETE FROM aircrafts WHERE id_aircraft =" + id );
    }



}
