package com.napier.sem;

import com.napier.sem.objects.City;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CityQueriesTest {

    private static App app;

    @BeforeClass
    public static void setup() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCitiesInDistrictByLargestToSmallestPopulationInvalidInput() {
        List<City> query = app.getCitiesInDistrictDescending(null);
    }

    @Test
    public void getCitiesInCountryByLargestToSmallestPopulation() {
        String inputCountry = "Germany";
        List<City> query = app.getCitiesInCountryDescending(inputCountry);
        int expectedRows = 93;
        int actualRows = query.size();
        int expectedTopPop = 3386667;
        int actualTopPop = query.get(0).getPopulation();

        assertEquals(expectedRows, actualRows);
        assertEquals(expectedTopPop, actualTopPop);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopNPopulatedCitiesInAContinentDescendingNull() {
        List<City> query = app.getTopNPopulatedCitiesInAContinentDescending(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopNPopulatedCitiesInTheWorld() {
        List<City> query = app.getTopNPopulatedCitiesInTheWorld(5000);
    }

    @Test
    public void getCitiesWithinContinent() {
        String inputContinent = "Africa";
        int expectedRows = 366;
        int expectedTopPop = 6789479;
        List<City> query = app.getTopCitiesInContinent(inputContinent);
        int actualRows = query.size();
        int actualTopPop = query.get(0).getPopulation();

        assertEquals(expectedRows, actualRows);
        assertEquals(expectedTopPop, actualTopPop);
    }

    @Test
    public void getTopNCapitalsInContinent() {
        String inputContinent = "Asia";
        int topN = 5;
        int expectedTopPop = 9981619;
        List<City> query = app.getTopNCapitalsInContinent(topN, inputContinent);
        int actualRows = query.size();
        int actualTopPop = query.get(0).getPopulation();

        assertEquals(topN, actualRows);
        assertEquals(expectedTopPop, actualTopPop);
    }
}
