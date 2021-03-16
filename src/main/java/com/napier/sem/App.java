package com.napier.sem;

import com.napier.sem.driver.DBDriverMysql;
import com.napier.sem.objects.Country;
import com.napier.sem.queries.ContinentQueries;

import java.sql.SQLOutput;
import java.util.List;

public class App {
    private static final String DB_URL = "jdbc:mysql://db:3306/world?useSSL=false";
    private static final String DB_PASSWORD = "semcoursework";

    public static void main(String[] args) {
        DBDriverMysql db = new DBDriverMysql(DB_URL, DB_PASSWORD);

        db.connect();

        ContinentQueries continentQueries = new ContinentQueries(db.getConn());

        List<Country> countries = continentQueries.getPopulationDescending();

        for (var country : countries) {
            System.out.println(country.toString());
        }
        db.disconnect();
    }

}