package com.napier.sem;

import com.napier.sem.driver.DBDriverMysql;
import com.napier.sem.objects.Country;
import com.napier.sem.queries.WorldQueries;

import java.util.List;

public class App {

    private static final String DB_URL_PREFIX = "jdbc:mysql://";
    private static final String DB_URL_POSTFIX = "/world?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String DB_PASSWORD = "semcoursework";

    private DBDriverMysql dbDriver;

    public static void main(String[] args) {

    }

    public List<Country> getWorldCountriesAscending() {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getPopulationAscending();
    }
    
    public List<Country> getWorldCountriesDescending() {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getPopulationDescending();
    }

    public List<Country> getContinentCountriesDescending(String Continent) {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getContinentPopulationDescending(Continent);
    }

    public List<Country> getContinentCountriesAscending(String Continent) {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getContinentPopulationAscending(Continent);
    }

    public List<Country> getCountryInRegionPopDescending(String Region) {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getCountryInRegionPopDescending(Region);
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