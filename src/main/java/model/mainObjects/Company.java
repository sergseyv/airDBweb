package model.mainObjects;

import model.Constants;
import model.DBConnection;
import model.RestoreDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class Company {
    private int idCompany;
    private String name;
    private String country;

    private Company(int idCompany, String name, String country) {
        this.idCompany = idCompany;
        this.name = name;
        this.country = country;
    }

    public Company(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Company() {}

    public int getIdCompany() {
        return idCompany;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    @Override
    public int hashCode() {
        return Objects.hash( idCompany, name, country );
    }


    // "SELECT * from companies"   в список ArrayList
    public static List<Company> selectAll (Connection conn){

        ArrayList<Company> result = new ArrayList <>();

        try ( Statement st = conn.createStatement();
              ResultSet res = st.executeQuery(Constants.SELECT_ALL_COMPANIES)) {
            while (res.next()) {
                result.add ( new Company(
                        res.getInt("id_companies"),
                        res.getString("name"),
                        res.getString("country"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    //  Добавление Company,  3 варианта параметров

    public static void add( Company company ) {
        Connection conn = DBConnection.getIstance().getConnection();
        add(conn, company);
    }

    public static void add( Connection conn, Company company ) {
        try (PreparedStatement pst = conn.prepareStatement(Constants.ADD_COMPANIES)) {
            add (pst, company);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add( PreparedStatement pst, Company company ) {
        try {
            pst.setString(1, company.name);
            pst.setString(2, company.country);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void upd ( Company company ) {
        Connection conn = DBConnection.getIstance().getConnection();
        upd (conn, company);
    }

    public static void upd ( Connection conn, Company company ) {

        int idCompany = company.getIdCompany();
        String name = company.getName();
        String country = company.getCountry();

        if ( ( name != null ) || ( country != null ) ) {

            StringBuilder query = new StringBuilder("UPDATE companies SET ");

            if ( name != null )
                query.append("name = '").append(name).append("', ");

            if ( country != null )
                query.append("country = '").append(country).append("', ");


            query.deleteCharAt(query.length()-2);   // удаляем последнюю запятую

            query.append("WHERE id_companies = ").append(idCompany).append(";");

            RestoreDB.doQuery(conn, query.toString());

        }

    }


    public static void del(String id){

        Connection conn = DBConnection.getIstance().getConnection();
        del (conn, id);
    }

    public static void del ( Connection conn, String id ){

        RestoreDB.doQuery ( conn, "DELETE FROM companies WHERE id_companies =" + id );
    }



}
