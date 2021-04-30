package com.napier.sem;

import com.napier.sem.driver.DBDriverMysql;
import com.napier.sem.objects.*;
import com.napier.sem.queries.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final String DB_URL_PREFIX = "jdbc:mysql://";
    private static final String DB_URL_POSTFIX = "/world?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String DB_PASSWORD = "semcoursework";

    private DBDriverMysql dbDriver;

    public static void main(String[] args) {
        App app = new App();
        app.connect("localhost:33060");

        boolean flag = true;
        Scanner in = new Scanner(System.in);
        int menuItem;
        String stringHolder;
        int numHolder;
        List<Country> countryResult = new ArrayList<Country>();
        List<City> cityResult = new ArrayList<City>();

        // Print menu
        System.out.println("1. Get top n populated countries in a continent");
        System.out.println("2. Get top n populated countries in the world");
        System.out.println("3. Get top n populated countries in  a region");
        System.out.println("4. Get region countries in ascending order");
        System.out.println("5. Get region countries in descending order");
        System.out.println("6. Get world countries in ascending order");
        System.out.println("7. Get world countries in descending order");
        System.out.println("8. Get continent countries in ascending order");
        System.out.println("9. Get continent countries in descending order");
        System.out.println("10. Get city population");
        System.out.println("11. Get country population");
        System.out.println("12. Get continent population");
        System.out.println("13. Get region population");
        System.out.println("14. Get district population");
        System.out.println("15. Get cities in district descending");
        System.out.println("16. Get cities in country descending");
        System.out.println("17. Get top n populated cities in a continent descending");
        System.out.println("18. Get top n populated cities in the world");
        System.out.println("19. Get world population");

        // Switch..case statements to execute respective queries
        do {
            System.out.println("Choose menu item: (enter only the number)");
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    // Hygiene - add to every case statement
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter continent: ");
                    stringHolder = app.getInput();
                    System.out.println("Enter number: ");
                    numHolder = in.nextInt();
                    countryResult = app.getTopNPopulatedCountriesInAContinent(stringHolder, numHolder);
                    app.printCountries(countryResult);
                    break;
                case 2:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter number: ");
                    numHolder = in.nextInt();
                    countryResult = app.getTopNPopulatedCountriesInTheWorld(numHolder);
                    app.printCountries(countryResult);
                    break;
                case 3:
                    // Hygiene
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter region: ");
                    stringHolder = app.getInput();
                    System.out.println("Enter number: ");
                    numHolder = in.nextInt();
                    countryResult.clear();
                    countryResult = app.getTopNPopulatedCountriesInRegion(stringHolder, numHolder);
                    app.printCountries(countryResult);
                    break;
                case 4:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter region: ");
                    stringHolder = app.getInput();
                    countryResult = app.getRegionCountriesAscending(stringHolder);
                    app.printCountries(countryResult);
                    break;
                case 5:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter region: ");
                    stringHolder = app.getInput();
                    countryResult = app.getRegionCountriesDescending(stringHolder);
                    app.printCountries(countryResult);
                    break;
                case 6:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    countryResult = app.getWorldCountriesAscending();
                    app.printCountries(countryResult);
                    break;
                case 7:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    countryResult = app.getWorldCountriesDescending();
                    app.printCountries(countryResult);
                    break;
                case 8:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter continent: ");
                    stringHolder = app.getInput();
                    countryResult = app.getContinentCountriesAscending(stringHolder);
                    app.printCountries(countryResult);
                    break;
                case 9:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter continent: ");
                    stringHolder = app.getInput();
                    countryResult = app.getContinentCountriesDescending(stringHolder);
                    app.printCountries(countryResult);
                    break;
                case 10:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter city: ");
                    stringHolder = app.getInput();
                    cityResult = app.getCityPopulation(stringHolder);
                    app.printCityPopulation(cityResult);
                    break;
                case 11:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter country: ");
                    stringHolder = app.getInput();
                    countryResult = app.getCountryPopulation(stringHolder);
                    app.printCountryPopulation(countryResult);
                    break;
                case 12:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter continent: ");
                    stringHolder = app.getInput();
                    Continent continent = app.getContinentPopulation(stringHolder);
                    app.printContinentPopulation(continent);
                    break;
                case 13:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter region: ");
                    stringHolder = app.getInput();
                    Region region = app.getRegionPopulation(stringHolder);
                    app.printRegionPopulation(region);
                    break;
                case 14:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter district: ");
                    stringHolder = app.getInput();
                    District district = app.getDistrictPopulation(stringHolder);
                    app.printDistrictPopulation(district);
                    break;
                case 15:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter district: ");
                    stringHolder = app.getInput();
                    cityResult = app.getCitiesInDistrictDescending(stringHolder);
                    app.printCities(cityResult);
                    break;
                case 16:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter country: ");
                    stringHolder = app.getInput();
                    cityResult = app.getCitiesInCountryDescending(stringHolder);
                    app.printCities(cityResult);
                    break;
                case 17:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter continent: ");
                    stringHolder = app.getInput();
                    System.out.println("Enter number: ");
                    numHolder = in.nextInt();
                    cityResult = app.getTopNPopulatedCitiesInAContinentDescending(stringHolder, numHolder);
                    app.printCities(cityResult);
                    break;
                case 18:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();

                    System.out.println("Enter number: ");
                    numHolder = in.nextInt();
                    cityResult = app.getTopNPopulatedCitiesInTheWorld(numHolder);
                    app.printCities(cityResult);
                    break;
                case 19:
                    stringHolder = "";
                    numHolder = 0;
                    countryResult.clear();
                    cityResult.clear();
                    break;
                case 0:
                    flag = false;
                    break;
            }

        } while (flag);

        app.disconnect();
    }

    /**
     * Helper method to read a string from the command line
     * @return input string
     */
    public String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            input = reader.readLine();
            return input;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
     * Gets a population of a district
     * @param district
     * @return the population of a district
     */
    public District getDistrictPopulation(String district) {
        DistrictQueries districtQueries = new DistrictQueries(dbDriver.getConn());
        return districtQueries.getPopulation(district);
    }

    /**
     * Gets a population of cities in a district organised by largest to smallest
     * @param district
     * @return a list of cities
     */
    public List<City> getCitiesInDistrictDescending(String district) {
        CityQueries cityQueries = new CityQueries(dbDriver.getConn());
        return cityQueries.getCitiesInDistrictByLargestToSmallestPopulation(district);
    }

    public long getWorldPopulation() {
        WorldQueries worldQueries = new WorldQueries(dbDriver.getConn());
        return worldQueries.getWorldPopulation();
    }

    public List<City> getCitiesInCountryDescending(String country) {
        CityQueries cityQueries = new CityQueries(dbDriver.getConn());
        return cityQueries.getCitiesInCountryByLargestToSmallestPopulation(country);
    }

    /**
     * Gets top N populated cities in a continent organised by largest to smallest population
     * @param continent
     * @param num
     * @return a list of N cities in a continent organised by largest to smallest
     */
    public List<City> getTopNPopulatedCitiesInAContinentDescending(String continent, int num) {
        CityQueries cityQueries = new CityQueries(dbDriver.getConn());
        return cityQueries.getTopNPopulatedCitiesInAContinentDescending(continent, num);
    }

    /**
     * Gets top N populated cities in the world
     * @param number
     * @return a list of top populated citis in the world
     */
    public List<City> getTopNPopulatedCitiesInTheWorld(int number) {
        CityQueries cityQueries = new CityQueries(dbDriver.getConn());
        return cityQueries.getTopNPopulatedCitiesInTheWorld(number);
    }

    /**
     * Helper method to print countries
     * @param countries
     */
    public void printCountries(List<Country> countries) {
        if (countries == null) {
            System.out.println("Countries list is empty");
            return;
        } else {
            // Print header
            System.out.println("Countries: ");
            for (Country c : countries) {
                if (c == null) {
                    continue;
                }
                String c_string = c.getName();
                System.out.println(c_string);
            }
        }
    }

    /**
     * Helper method to print cities
     * @param cities
     */
    public void printCities(List<City> cities) {
        if (cities == null) {
            System.out.println("Cities list is empty");
            return;
        } else {
            // Print header
            System.out.println("Cities: ");
            for (City c : cities) {
                if (c == null) {
                    continue;
                }
                String c_string = c.getName();
                System.out.println(c_string);
            }
        }
    }

    /**
     * Helper method to print city population
     * @param cities
     */
    public void printCityPopulation(List<City> cities) {
        if (cities == null) {
            System.out.println("No city found");
            return;
        } else {
            // Print header
            System.out.println("Population: ");
            for (City c : cities) {
                if (c == null) {
                    continue;
                }
                String c_string = c.getName() + " " + c.getPopulation();
                System.out.println(c_string);
            }
        }
    }

    /**
     * Helper method to print country population
     * @param countries
     */
    public void printCountryPopulation(List<Country> countries) {
        if (countries == null) {
            System.out.println("No country found");
            return;
        } else {
            // Print header
            System.out.println("Population: ");
            for (Country c : countries) {
                if (c == null) {
                    continue;
                }
                String c_string = c.getName() + " " + c.getPopulation();
                System.out.println(c_string);
            }
        }
    }

    /**
     * Helper method to print continent population
     * @param continent
     */
    public void printContinentPopulation(Continent continent) {
        if (continent == null) {
            System.out.println("No continent found");
            return;
        } else {
            System.out.println("Population: ");
            System.out.println(continent.getName() + " - " + continent.getPopulation());
        }
    }

    /**
     * Helper method to print region population
     * @param region
     */
    public void printRegionPopulation(Region region) {
        if (region == null) {
            System.out.println("No region found");
            return;
        } else {
            System.out.println("Population: ");
            System.out.println(region.getName() + " - " + region.getPopulation());
        }
    }

    /**
     * Helper method to print district population
     * @param district
     */
    public void printDistrictPopulation(District district) {
        if (district == null) {
            System.out.println("No district found");
            return;
        } else {
            System.out.println("Population: ");
            System.out.println(district.getName() + " - " + district.getPopulation());
        }
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