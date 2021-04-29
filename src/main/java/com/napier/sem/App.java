package com.napier.sem;

import com.napier.sem.driver.DBDriverMysql;
import com.napier.sem.objects.*;
import com.napier.sem.queries.*;

import java.util.List;

public class App {

    private static final String DB_URL_PREFIX = "jdbc:mysql://";
    private static final String DB_URL_POSTFIX = "/world?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String DB_PASSWORD = "semcoursework";

    private DBDriverMysql dbDriver;

    public static void main(String[] args) {

    }

    /**
     * Gets top N populated countries in a continent provided by the user.
     * @param continent
     * @param number
     * @return list of countries
     */
    public List<Country> getTopNPopulatedCountriesInAContinent(String continent, int number) {
        WorldQueries worldQueries = new WorldQueries(dbDriver.getConn());
        return worldQueries.getTopNPopulatedCountriesInAContinent(continent, number);
    }

    /**
     * Gets top N populated countries in the world provided by the user.
     * @param number
     * @return list of countries
     */
    public List<Country> getTopNPopulatedCountriesInTheWorld(int number) {
        WorldQueries worldQueries = new WorldQueries(dbDriver.getConn());
        return worldQueries.getTopNPopulatedCountriesInTheWorld(number);
    }

    /**
     * Gets top N populated countries in a region provided by the user
     *
     * @param
     * @return list of countries
     */
    public List<Country> getTopNPopulatedCountriesInRegion(String region, int number) {
        RegionQueries regionQueries = new RegionQueries(dbDriver.getConn());
        return regionQueries.getTopNPopulatedCountriesInRegion(region, number);
    }

    /**
     * Gets region population sorted in ascending order.
     * @return list of countries
     */
    public List<Country> getRegionCountriesAscending(String region) {
        RegionQueries regionQueries = new RegionQueries(dbDriver.getConn());
        return regionQueries.getRegionPopulationAscending(region);
    }

    /**
     * Gets region population sorted in descending order.
     * @return list of countries
     */
    public List<Country> getRegionCountriesDescending(String region) {
        RegionQueries regionQueries = new RegionQueries(dbDriver.getConn());
        return regionQueries.getRegionPopulationDescending(region);
    }


    /**
     * Gets world population from lowest to highest.
     * @return list of sorted countries
     */
    public List<Country> getWorldCountriesAscending() {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getPopulationAscending();
    }

    /**
     * Gets world population from highest to lowest.
     * @return List of countries
     */
    public List<Country> getWorldCountriesDescending() {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getPopulationDescending();
    }

    /**
     * Gets world population from highest to lowest.
     * @return List of countries
     */
    public List<Country> getContinentCountriesDescending(String Continent) {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getContinentPopulationDescending(Continent);
    }

    /**
     * Gets world population from lowest to highest.
     * @return list of sorted countries
     */
    public List<Country> getContinentCountriesAscending(String Continent) {
        WorldQueries continentQueries = new WorldQueries(dbDriver.getConn());
        return continentQueries.getContinentPopulationAscending(Continent);
    }

    /**
     * Gets a population of a city
     * @param city
     * @return a list containing the specified city and its population (a list in case there are multiple cities with the same name e.g. Memphis, Egypt and Memphis, Tennessee)
     */
    public List<City> getCityPopulation(String city) {
        CityQueries cityQueries = new CityQueries(dbDriver.getConn());
        return cityQueries.getCityPopulation(city);
    }

    /**
     * Gets a population of a country
     * @param country
     * @return a list containing the specified country and its population (a list in case there are countries with the same name)
     */
    public List<Country> getCountryPopulation(String country) {
        WorldQueries worldQueries = new WorldQueries(dbDriver.getConn());
        return worldQueries.getCountryPopulation(country);
    }

    /**
     * Gets population of a continent
     * @param continent
     * @return the population of a continent
     */
    public Continent getContinentPopulation(String continent) {
        ContinentQueries continentQueries = new ContinentQueries(dbDriver.getConn());
        return continentQueries.getContinentPopulation(continent);
    }

    /**
     * Gets population of a region
     * @param region
     * @return the population of a region
     */
    public Region getRegionPopulation(String region) {
        RegionQueries regionQueries = new RegionQueries(dbDriver.getConn());
        return regionQueries.getTotalPopulationOfRegion(region);
    }

    /**
     *
     * @param district
     * @return the population of a district
     */
    public District getDistrictPopulation(String district) {
        DistrictQueries districtQueries = new DistrictQueries(dbDriver.getConn());
        return districtQueries.getPopulation(district);
    }

    /**
     *
     * @param district
     * @return a list of cities in district organised by population from largest to smallest
     */
    public List<City> getCitiesInDistrictDescending(String district) {
        CityQueries cityQueries = new CityQueries(dbDriver.getConn());
        return cityQueries.getCitiesInDistrictByLargestToSmallestPopulation(district);
    }

    public long getWorldPopulation() {
        WorldQueries worldQueries = new WorldQueries(dbDriver.getConn());
        return worldQueries.getWorldPopulation();
    }

    /**
     * Connect to the DB
     * @param location
     */
    public void connect(String location) {
        String url = DB_URL_PREFIX + location + DB_URL_POSTFIX;
        dbDriver = new DBDriverMysql(url, DB_PASSWORD);
        dbDriver.connect();
    }

    /**
     * Disconnect from the DB
     */
    public void disconnect() {
        dbDriver.disconnect();
    }

}