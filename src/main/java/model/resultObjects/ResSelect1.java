package model.resultObjects;

import model.Constants;
import model.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
Класс реализует пример выполнения SQL запроса,
выбор из нескольких таблиц с объединением.
Текст запроса в константе: Constants.SELECT1
Результат - список объектов, содержащих значения из
результирующей таблицы.
 */
public class ResSelect1 {
    private String nameCompany;
    private String countryCompany;
    private String nameAircraft;
    private int quantity;

    private ResSelect1(String nameCompany, String countryCompany, String nameAircraft, int quantity) {
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
    

    public static List<ResSelect1> selectAll (){

        Connection conn = DbConnection.getIstance().getConnection();
        List <ResSelect1> result = new ArrayList<>();

        try (Statement st = conn.createStatement();
             ResultSet res = st.executeQuery(Constants.SELECT1)) {
            while (res.next()) {
                result.add ( new ResSelect1(
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbConnection.getIstance().closeConnection(conn);
        return result;
    }

}
