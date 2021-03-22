package com.napier.sem;

import com.napier.sem.driver.DBDriverMysql;
import com.napier.sem.objects.Country;
import com.napier.sem.queries.WorldQueries;

import java.util.List;

public class App {
    private static final String DB_URL = "jdbc:mysql://db:3306/world?useSSL=false";
    private static final String DB_PASSWORD = "semcoursework";

    public static void main(String[] args) {
        DBDriverMysql db = new DBDriverMysql(DB_URL, DB_PASSWORD);

        db.connect();

        WorldQueries continentQueries = new WorldQueries(db.getConn());

        List<Country> countriesDesc = continentQueries.getPopulationDescending();
        List<Country> countriesAsc = continentQueries.getPopulationAscending();

        for(int i = 0; i < countriesAsc.size(); i++) {
            System.out.println(countriesAsc.get(i));
            System.out.println(countriesDesc.get(i));
        }
        db.disconnect();
    }

}