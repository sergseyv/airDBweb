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
public class ResSelect4 {
    private String nameCompany;
    private String countryCompany;
    private int quantity;
    private int passengers;

    public ResSelect4(String nameCompany, String countryCompany, int quantity, int passengers) {
        this.nameCompany = nameCompany;
        this.countryCompany = countryCompany;
        this.quantity = quantity;
        this.passengers = passengers;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getCountryCompany() {
        return countryCompany;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPassengers() {
        return passengers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCompany, countryCompany, quantity, passengers);
    }


    public static List<ResSelect4> selectAll (Connection conn){

        List <ResSelect4> result = new ArrayList<>();

        try (Statement st = conn.createStatement();
             ResultSet res = st.executeQuery(Constants.SELECT4)) {
            while (res.next()) {
                result.add ( new ResSelect4(
                        res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getInt(4))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }



}
