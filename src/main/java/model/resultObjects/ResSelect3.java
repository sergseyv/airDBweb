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
Текст запроса в константе: Constants.SELECT3
Результат - список объектов, содержащих значения из
результирующей таблицы.
 */
public class ResSelect3 {
    private String nameCompany;
    private String countryCompany;
    private int quantity;

    private ResSelect3(String nameCompany, String countryCompany, int quantity) {
        this.nameCompany = nameCompany;
        this.countryCompany = countryCompany;
        this.quantity = quantity;
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


    public static List<ResSelect3> selectAll (){
        Connection conn = DbConnection.getIstance().getConnection();
        List <ResSelect3> result = new ArrayList<>();

        try (Statement st = conn.createStatement();
             ResultSet res = st.executeQuery(Constants.SELECT3)) {
            while (res.next()) {
                result.add ( new ResSelect3(
                        res.getString(1),
                        res.getString(2),
                        res.getInt(3))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbConnection.getIstance().closeConnection(conn);
        return result;
    }

}
