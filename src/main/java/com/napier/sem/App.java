package com.napier.sem;

import com.napier.sem.driver.DBDriverMysql;
import com.napier.sem.objects.Country;
import com.napier.sem.queries.RegionQueries;
import com.napier.sem.queries.WorldQueries;

import java.util.List;

public class App {

    private static final String DB_URL_PREFIX = "jdbc:mysql://";
    private static final String DB_URL_POSTFIX = "/world?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String DB_PASSWORD = "semcoursework";

    private DBDriverMysql dbDriver;

    public static void main(String[] args) {

    }

    /**
     * Gets region population sorted in ascending order.
     * @return list of countries
     */
    public List<Country> getRegionCountriesAscending(String region) {
        RegionQueries regionQueries = new RegionQueries(dbDriver.getConn());
        return regionQueries.getRegionPopulationAscending(region);
    }

    /**
     * Gets region population sorted in descending order.
     * @return list of countries
     */
    public List<Country> getRegionCountriesDescending(String region) {
        RegionQueries regionQueries = new RegionQueries(dbDriver.getConn());
        return regionQueries.getRegionPopulationDescending(region);
    }


    /**
     * Gets world population from lowest to highest.
     * @return list of sorted countries
     */
    public List<Country> getWorldCountriesAscending() {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getPopulationAscending();
    }

    /**
     * Gets world population from highest to lowest.
     * @return List of countries
     */
    public List<Country> getWorldCountriesDescending() {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getPopulationDescending();
    }

    /**
     * Gets world population from highest to lowest.
     * @return List of countries
     */
    public List<Country> getContinentCountriesDescending(String Continent) {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getContinentPopulationDescending(Continent);
    }

    /**
     * Gets world population from lowest to highest.
     * @return list of sorted countries
     */
    public List<Country> getContinentCountriesAscending(String Continent) {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getContinentPopulationAscending(Continent);
    }

    public void connect(String location) {
        String url = DB_URL_PREFIX + location + DB_URL_POSTFIX;
        dbDriver = new DBDriverMysql(url, DB_PASSWORD);
        dbDriver.connect();
    }

    public void disconnect() {
        dbDriver.disconnect();
    }

}