package model.resultObjects;

import model.Constants;
import model.DbConnection;

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
public class ResSelect2 {
    private String nameCompany;
    private String countryCompany;
    private String nameAircraft;
    private int maxRangeAircraft;
    private int quantity;

    private ResSelect2(String nameCompany, String countryCompany, String nameAircraft, int maxRangeAircraft, int quantity) {
        this.nameCompany = nameCompany;
        this.countryCompany = countryCompany;
        this.nameAircraft = nameAircraft;
        this.maxRangeAircraft = maxRangeAircraft;
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

    public int getMaxRangeAircraft() {
        return maxRangeAircraft;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCompany, countryCompany, nameAircraft, maxRangeAircraft, quantity);
    }


    public static List<ResSelect2> selectAll (){

        Connection conn = DbConnection.getIstance().getConnection();
        List <ResSelect2> result = new ArrayList<>();

        try (Statement st = conn.createStatement();
             ResultSet res = st.executeQuery(Constants.SELECT2)) {
            while (res.next()) {
                result.add ( new ResSelect2(
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4),
                        res.getInt(5))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbConnection.getIstance().closeConnection(conn);
        return result;
    }





}
