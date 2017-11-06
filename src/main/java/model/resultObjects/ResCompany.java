package model.resultObjects;

import model.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Seyvach Serg on 01.11.2017.
 */
public class ResCompany {
    private int idCompany;
    private String name;
    private String country;

    private ResCompany(int idCompany, String name, String country) {
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


    public static List<ResCompany> selectAll (Connection conn){

        ArrayList<ResCompany> result = new ArrayList <>();

        try (Statement st = conn.createStatement();
             ResultSet res = st.executeQuery(Constants.SELECT_ALL_COMPANIES)) {
            while (res.next()) {
                result.add ( new ResCompany(
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
