package model.resultObjects;

import model.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class ObjCompany {
    private int idCompany;
    private String name;
    private String country;

    private ObjCompany(int idCompany, String name, String country) {
        this.idCompany = idCompany;
        this.name = name;
        this.country = country;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }


    @Override
    public int hashCode() {
        return Objects.hash( idCompany, name, country );
    }


    public static List<ObjCompany> selectAll (Connection conn){

        ArrayList<ObjCompany> result = new ArrayList <>();

        try (Statement st = conn.createStatement();
             ResultSet res = st.executeQuery(Constants.SELECT_ALL_COMPANIES)) {
            while (res.next()) {
                result.add ( new ObjCompany(
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

}
