package com.napier.sem.queries;

import com.napier.sem.objects.Country;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

public class RegionQueries {
    private Connection conn;

    public RegionQueries(Connection conn) {
        this.conn = conn;
    }

    /**
     * Gets region population sorted in ascending order.
     * @return
     */
    public List<Country> getRegionPopulationAscending(String region){
        return getRegionPopulation(region);
    }

    /**
     * Gets region population sorted in descending order.
     * @return
     */
    public List<Country> getRegionPopulationDescending(String region){
        List<Country> result = getRegionPopulation(region);
        Collections.reverse(result);
        return result;
    }

    /**
     * Gets region population sorted in ascending order.
     * @param region
     * @return
     */
    private List<Country> getRegionPopulation(String region) {
        throw new UnsupportedOperationException(); // will implement later
    }


    // getRegionPopulation
}
