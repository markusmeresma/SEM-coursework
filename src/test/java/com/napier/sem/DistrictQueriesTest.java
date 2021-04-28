package com.napier.sem;

import com.napier.sem.objects.District;
import org.junit.BeforeClass;
import org.junit.Test;

public class DistrictQueriesTest {

    private static App app;

    @BeforeClass
    public static void setup() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistrictPopulationEmpty() {
        District query = app.getDistrictPopulation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistrictPopulationNull() {
        District query = app.getDistrictPopulation(null);
    }
}
