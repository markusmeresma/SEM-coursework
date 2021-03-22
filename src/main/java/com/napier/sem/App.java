package com.napier.sem;

import com.napier.sem.driver.DBDriverMysql;
import com.napier.sem.objects.Country;
import com.napier.sem.queries.WorldQueries;

import java.util.List;

public class App {
    private static final String DB_URL = "jdbc:mysql://db:3306/world?useSSL=false";
    private static final String DB_PASSWORD = "semcoursework";

    private DBDriverMysql dbDriver;

    public static void main(String[] args) {

    }

    public List<Country> getWorldCountriesAscending() {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getPopulationAscending();
    }

    public void connect() {
        dbDriver = new DBDriverMysql(DB_URL, DB_PASSWORD);
        dbDriver.connect();
    }

    public void disconnect() {
        dbDriver.disconnect();
    }

}