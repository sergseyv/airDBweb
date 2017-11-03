package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class entityCompany {
    private int idCompany;
    private String name;
    private String country;

    private entityCompany(int idCompany, String name, String country) {
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


    public static List<entityCompany> selectAll (Connection conn){

        ArrayList<entityCompany> result = new ArrayList <>();

        try (Statement st = conn.createStatement();
             ResultSet res = st.executeQuery(Constants.SELECT_ALL_COMPANIES)) {
            while (res.next()) {
                result.add ( new entityCompany (
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
