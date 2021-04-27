package com.napier.sem;

import com.napier.sem.objects.Country;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WorldQueriesTest {

    private static App app;

    @BeforeClass
    public static void setup() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTopNPopulatedCountriesInAContinentIfNIsGreaterThanTheNumberOfCountries() {
        app.getTopNPopulatedCountriesInAContinent("Asia", 1000);
    }

    @Test
    public void testGetTopNPopulatedCountriesInAContinentIfNReturnsCorrectCountries() {
        int expected = 10;

        List<Country> query = app.getTopNPopulatedCountriesInAContinent("Asia", expected);

        int actual = query.size();

        int actualCountryPopulation = query.get(0).getPopulation();
        int expectedCountryPopulation = 1277558000;

        assertEquals("The result size must be 10.", expected, actual);
        assertEquals(expectedCountryPopulation, actualCountryPopulation);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetTopNPopulatedCountriesInTheWorldIfNIsGreaterThanTheNumberOfCountries() {
        app.getTopNPopulatedCountriesInTheWorld(1000);
    }

    @Test
    public void testGetTopNPopulatedCountriesInTheWorldIfNReturnsCorrectCountries() {
        int expected = 10;

        List<Country> query = app.getTopNPopulatedCountriesInTheWorld(expected);

        int actual = query.size();

        int actualCountryPopulation = query.get(0).getPopulation();
        int expectedCountryPopulation = 1277558000;

        assertEquals("The result size must be 10.", expected, actual);
        assertEquals(expectedCountryPopulation, actualCountryPopulation);
    }


    @AfterClass
    public static void close() {
        app.disconnect();
    }
}
