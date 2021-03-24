package com.napier.sem;

import com.napier.sem.objects.Country;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * We need to use some mocking framework in order to test the queries
 * I propose Mockito - Gabriel
 */
public class WorldQueriesTest {

    private static App app;


    @BeforeClass
    public static void setup() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    public void getContinents() {
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
