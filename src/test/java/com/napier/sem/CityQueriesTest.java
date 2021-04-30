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
}
