package model.resultObjects;

import model.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Seyvach Serg on 06.11.2017.
 */
public class ObjSelect1 {
    private String nameCompany;
    private String countryCompany;
    private String nameAircraft;
    private int quantity;

    private ObjSelect1(String nameCompany, String countryCompany, String nameAircraft, int quantity) {
        this.nameCompany = nameCompany;
        this.countryCompany = countryCompany;
        this.nameAircraft = nameAircraft;
        this.quantity = quantity;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getCountryCompany() {
        return countryCompany;
    }

    public String getNameAircraft() {
        return nameAircraft;
    }

    public int getQuantity() {
        return quantity;
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(nameCompany, countryCompany, nameAircraft, quantity);
    }


    public static List<ObjSelect1> selectAll (Connection conn){

        List <ObjSelect1> result = new ArrayList<>();

        try (Statement st = conn.createStatement();
             ResultSet res = st.executeQuery(Constants.SELECT1)) {
            while (res.next()) {
                result.add ( new ObjSelect1(
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }








}
