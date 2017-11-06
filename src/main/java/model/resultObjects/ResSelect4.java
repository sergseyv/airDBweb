package model.resultObjects;

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


}
