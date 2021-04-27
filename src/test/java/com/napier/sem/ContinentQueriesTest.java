package com.napier.sem;

import com.napier.sem.objects.Continent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContinentQueriesTest {

    private static App app;

    @BeforeClass
    public static void setup() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getContinentPopulationTestEmpty() {
        Continent query = app.getContinentPopulation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getContinentPopulationTestNull() {
        Continent query = app.getContinentPopulation(null);
    }

    @AfterClass
    public static void close() {
        app.disconnect();
    }
}
