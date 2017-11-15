package model.mainObjects;

import model.Constants;
import model.DbConnection;
import model.DbWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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


    // "SELECT * from companies"   в список ArrayList
    public static List<Company> selectAll (){

        Connection conn = DbConnection.getIstance().getConnection();
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
        DbConnection.getIstance().closeConnection(conn);
        return result;
    }


    public static void add( Company company ) {
        Connection conn = DbConnection.getIstance().getConnection();
        add(conn, company);
        DbConnection.getIstance().closeConnection(conn);
    }

    public static void add( Connection conn, Company company ) {
        try (PreparedStatement pst = conn.prepareStatement(Constants.ADD_COMPANIES)) {
            add (pst, company);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // добавление новой записи в БД
    public static void add( PreparedStatement pst, Company company ) {
        try {
            pst.setString(1, company.name);
            pst.setString(2, company.country);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Изменение значения Company в таблице, по ID
    public static void upd ( Company company ) {

        int idCompany = company.getIdCompany();
        String name = company.getName();
        String country = company.getCountry();

        /*
        Если пришло хотя бы одно ненулевое значение, составялем SQL-запрос
        на UPDATE ненулевых полей
         */
        if ( ( name != null ) || ( country != null ) ) {

            StringBuilder query = new StringBuilder("UPDATE companies SET ");

            if ( name != null )
                query.append("name = '").append(name).append("', ");

            if ( country != null )
                query.append("country = '").append(country).append("', ");

            query.deleteCharAt(query.length()-2);   // удаляем последнюю запятую

            query.append("WHERE id_companies = ").append(idCompany).append(";");

            DbWork.doQuery( query.toString() );
        }
    }

    // Удаление одной записи Company в таблице, по ID
    public static void del ( String id ){

        DbWork.doQuery ( "DELETE FROM companies WHERE id_companies =" + id );
    }


}
