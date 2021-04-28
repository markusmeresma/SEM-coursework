package com.napier.sem;

import com.napier.sem.objects.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

//TODO : I think we should test the connection here only
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
        String actualContinent = query.get(0).getName();
        String expectedContinent = "Nigeria";

        assertEquals(expectedContinent, actualContinent);

    }

    @Test
    public void testGetCityPopulation() {
        List<City> query = app.getCityPopulation("Tallinn");
        int actualPopulation = query.get(0).getPopulation();
        int expectedPopulation = 403981;

        assertEquals(expectedPopulation, actualPopulation);
    }

    @Test
    public void testGetCountryPopulation() {
        List<Country> query = app.getCountryPopulation("Estonia");
        int actualPopulation = query.get(0).getPopulation();
        int expectedPopulation = 1439200;

        assertEquals(expectedPopulation, actualPopulation);
    }

    @Test
    public void testGetContinentPopulation() {
        Continent query = app.getContinentPopulation("Asia");
        long actualPopulation = query.getPopulation();
        long expectedPopulation = 3705025700L;

        assertEquals(expectedPopulation, actualPopulation);
    }

    @Test
    public void testGetRegionPopulation() {
        Region query = app.getRegionPopulation("Southern Europe");
        long actualPopulation = query.getPopulation();
        long expectedPopulation = 144674200L;

        assertEquals(expectedPopulation, actualPopulation);
    }

    @Test
    public void testGetDistrictPopulation() {
        District query = app.getDistrictPopulation("Auckland");
        long actualPopulation = query.getPopulation();
        long expectedPopulation = 1021900L;

        assertEquals(expectedPopulation, actualPopulation);
    }

    @AfterClass
    public static void close() {
        app.disconnect();
    }
}
