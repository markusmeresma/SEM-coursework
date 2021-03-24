package com.napier.sem;

import com.napier.sem.objects.Country;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppIntegrationTest {

    private static App app;


    @BeforeClass
    public static void setup() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    public void testIfWorldQueriesGetDescendingReturnsCountries() {
        List<Country> query = app.getWorldCountriesDescending();
        long actualPopulation = query.get(0).getPopulation();
        long expectedPopulation = 1277558000;

        assertEquals(expectedPopulation, actualPopulation);
    }

    @Test
    public void testIfWorldQueriesGetAscendingReturnsCountries() {
        List<Country> query = app.getWorldCountriesAscending();
        long actualPopulation = query.get(0).getPopulation();
        long expectedPopulation = 0;

        assertEquals(expectedPopulation, actualPopulation);
    }

    @Test
    public void testIfWorldQueriesGetDescendingReturnsContinents() {
        List<Country> query = app.getContinentCountriesDescending("Africa");
        String actualPopulation = query.get(0).getName();
        String expectedPopulation = "Nigeria";

        assertEquals(expectedPopulation, actualPopulation);

    }

    @AfterClass
    public static void close() {
        app.disconnect();
    }
}
