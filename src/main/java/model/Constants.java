package model;

/**
 * Created by Seyvach Serg on 23.10.2017.
 */
public final class Constants {

    static final String DROP_AIRCRAFTS = "DROP TABLE IF EXISTS aircrafts; ";
    static final String DROP_COMPANIES = "DROP TABLE IF EXISTS companies; ";
    static final String DROP_OWNERSHIP = "DROP TABLE IF EXISTS ownership; ";

    static final String CREATE_AIRCRAFTS =
            " CREATE TABLE `aircrafts` ( " +
                    " `id_aircraft` INT NOT NULL AUTO_INCREMENT, " +
                    " `name` VARCHAR(30) NULL, " +
                    " `passengers` INT NULL, " +
                    " `max_weight__kg` INT NULL, " +
                    " `max_range__km` INT NULL, " +
                    " PRIMARY KEY (`id_aircraft`)); ";

    static final String CREATE_COMPANIES =
            " CREATE TABLE `companies` ( " +
                    " `id_companies` INT NOT NULL AUTO_INCREMENT, " +
                    " `name` VARCHAR(30) NULL, " +
                    " `country` VARCHAR(30) NULL, " +
                    " PRIMARY KEY (`id_companies`)); ";

    static final String CREATE_OWNERSHIP =
            " CREATE TABLE `ownership` ( " +
                    " `id_ownership` INT NOT NULL AUTO_INCREMENT, " +
                    " `id_companies` INT NULL, " +
                    " `id_aircraft` INT NULL, " +
                    " `quantity` INT NULL, " +
                    " PRIMARY KEY (`id_ownership`)); ";

    public static final String ADD_AIRCRAFTS =
            " INSERT INTO aircrafts (name, passengers, max_weight__kg, max_range__km) " +
                    " VALUES (?, ?, ?, ?) ";

    public static final String ADD_COMPANIES =
            " INSERT INTO companies (id_companies, name, country ) " +
                    " VALUES (?, ?, ?) ";

    public static final String ADD_OWNERSHIP =
            " INSERT INTO ownership (id_ownership, id_companies, id_aircraft, quantity ) " +
                    " VALUES (?, ?, ?, ?) ";

    public static final String SELECT_ALL_AIRCRAFTS = " SELECT * from aircrafts ";
    public static final String SELECT_ALL_COMPANIES = " SELECT * from companies ";
    public static final String SELECT_ALL_OWNERSHIPS = " SELECT * from ownership ";

    public static final String SELECT1 =   //просто соответствие самолетов компаниям
            " SELECT companies.name, companies.country, aircrafts.name,  ownership.quantity " +
                    " FROM ownership " +
                    " JOIN companies ON ownership.id_companies = companies.id_companies " +
                    " JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft ";

    public static final String SELECT2 = //выборка эйрбасов, упорядочена по макс.радиусу
            " SELECT companies.name, companies.country, aircrafts.name, aircrafts.max_range__km, ownership.quantity " +
                    " FROM ownership " +
                    " JOIN companies ON ownership.id_companies = companies.id_companies " +
                    " JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft " +
                    " WHERE aircrafts.name LIKE '%Airbus%' " +
                    " ORDER BY aircrafts.max_range__km ASC ";

    public static final String SELECT3 = // сколько боингов у каждой компании
            " SELECT companies.name, companies.country, SUM(ownership.quantity) " +
                    " FROM ownership " +
                    " JOIN companies ON ownership.id_companies = companies.id_companies " +
                    " JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft " +
                    " WHERE aircrafts.name LIKE '%Boeing%' " +
                    " GROUP BY ownership.id_companies " +
                    " ORDER BY SUM(ownership.quantity) DESC";

    public static final String SELECT4 = //сколько у каждой компании самолетов и сколько всего она может перевезти народу за раз.
            " SELECT companies.name, companies.country, " +
                    " SUM(ownership.quantity), SUM(ownership.quantity*aircrafts.passengers) " +
                    " FROM ownership " +
                    " JOIN companies ON ownership.id_companies = companies.id_companies " +
                    " JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft " +
                    " GROUP BY ownership.id_companies " +
                    " ORDER BY SUM(ownership.quantity*aircrafts.passengers) ASC ";

}
