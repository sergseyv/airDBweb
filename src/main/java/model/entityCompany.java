package model;

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
}
