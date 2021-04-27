package com.napier.sem;

import com.napier.sem.objects.Country;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegionQueriesTest {

    private static App app;

    @BeforeClass
    public static void setup() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testgetTopNPopulatedCountriesInRegionIfNIsGreaterThanTheNumberOfCountries() {
        app.getTopNPopulatedCountriesInRegion("Eastern Africa", 1000);
    }

    @Test
    public void testgetTopNPopulatedCountriesInRegionIfNReturnsCorrentNumberOfCountries() {
        int expected = 10;

        List<Country> query = app.getTopNPopulatedCountriesInRegion("Eastern Africa", expected);

        int actual = query.size();

        assertEquals("The result size must be 10.", expected, actual);
    }

    @Test
    public void testIfRegionQueriesReturnsCountriesInAscendingOrder() {
        List<Country> query = app.getRegionCountriesAscending("Eastern Africa");

        Country country = query.get(0);

        int expected = 0;
        int actual = country.getPopulation();

        String expectedName = "British Indian Ocean Territory";
        String actualName = country.getName();

        assertEquals("The smallest country should have 0 population.", expected, actual);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testIfRegionQueriesReturnsCountriesInDescendingOrder() {
        List<Country> query = app.getRegionCountriesDescending("Eastern Africa");

        Country country = query.get(0);

        int expected = 62565000;
        int actual = country.getPopulation();

        String expectedName = "Ethiopia";
        String actualName = country.getName();

        assertEquals("The biggest country should have 62565000 population.", expected, actual);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testIfRegionQueriesReturnEmptyListIfNoSuchRegionExist() {
        List<Country> actual = app.getRegionCountriesAscending("Region that can't possibly exist");
        assertTrue(actual.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfRegionQueriesReturnEmptyListIfRegionStringIsNull() {
        app.getRegionCountriesAscending(null);
    }

    @AfterClass
    public static void close() {
        app.disconnect();
    }
}
