package com.napier.sem;

import com.napier.sem.objects.Country;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppIntegrationTest {

    private App app;


    @BeforeClass
    public void setup() {
        app = new App();
        app.connect();
    }

    @Test
    public void testIfWorldQueriesGetAscendingReturnsCountries() {
        List<Country> query = app.getWorldCountriesAscending();
        int actualPopulation = query.get(0).getPopulation();
        int expectedPopulation = 1277558000;

        assertEquals(actualPopulation, expectedPopulation);
    }

    @AfterClass
    public void close() {
        app.disconnect();
    }
}
