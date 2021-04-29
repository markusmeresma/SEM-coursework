package com.napier.sem.queries;

import com.napier.sem.objects.Country;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorldQueries {
    private Connection conn;

    public WorldQueries(Connection conn) {
        this.conn = conn;
    }

    /**
     * Gets top N populated countries in a continent provided by the user.
     * @param continent
     * @param number
     * @return list of countries
     */
    public List<Country> getTopNPopulatedCountriesInAContinent(String continent, int number) {
        List<Country> result = getContinentPopulation(continent);

        if(number >= result.size()) {
            throw new IllegalArgumentException("The provided number is invalid. The number of countries in the world is " + result.size());
        }

        return result.subList(0, number);
    }



    /**
     * Gets top N populated countries in the world provided by the user.
     * @param number
     * @return list of countries
     */
    public List<Country> getTopNPopulatedCountriesInTheWorld(int number) {
        List<Country> result = getCountriesSortedDescending();

        if(number >= result.size()) {
            throw new IllegalArgumentException("The provided number is invalid. The number of countries in the world is " + result.size());
        }

        return result.subList(0, number);
    }


    /**
     * Gets world population from highest to lowest.
     * @return List of countries
     */
    public List<Country> getPopulationDescending() {
        // select name from country order by population desc;
        return getCountriesSortedDescending();
    }

    /**
     * Gets world population from lowest to highest.
     * @return sorted countries
     */
    public List<Country> getPopulationAscending() {
        List<Country> result = getCountriesSortedDescending();
        Collections.reverse(result);
        return result;
    }

    /**
     * Helper method that gets world population from highest to lowest.
     *
     * @return list of sorted countries sorted countries
     */
    private List<Country> getCountriesSortedDescending() {
        List<Country> result = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            statement.executeQuery("use world;");

            String query = "SELECT * " +
                    "FROM country " +
                    "ORDER BY population " +
                    "DESC;";


            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String countryName = resultSet.getString("name");
                String continent = resultSet.getString("continent");
                String region = resultSet.getString("region");
                int population = resultSet.getInt("population");

                result.add(new Country(countryName, continent, region, population));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    /**
     * Gets world population from highest to lowest.
     * @return List of countries
     */
    public List<Country> getContinentPopulationDescending(String Continent) {
        // select name from country order by population desc;
        return getContinentPopulation(Continent);
    }

    /**
     * Gets world population from lowest to highest.
     * @return list of sorted countries
     */
    public List<Country> getContinentPopulationAscending(String Continent) {
        List<Country> result = getContinentPopulationDescending(Continent);
        Collections.reverse(result);
        return result;
    }

    /**
     * Helper method that gets world population from highest to lowest.
     *
     * @return list of sorted countries sorted countries
     */
    private List<Country> getContinentPopulation(String Continent) {
        List<Country> result = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            statement.executeQuery("use world;");

            String query = "SELECT * " +
                    "FROM country " +
                    "WHERE continent LIKE ? "+
                    "ORDER BY population " +
                    "DESC;";


            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, Continent);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String countryName = resultSet.getString("name");
                String continent = resultSet.getString("continent");
                String region = resultSet.getString("region");
                int population = resultSet.getInt("population");

                result.add(new Country(countryName, continent, region, population));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    /**
     * Method to get a population of a country
     * @param name
     * @return
     */
    public List<Country> getCountryPopulation(String name)
    {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Country name is null or empty");
        }
        else {
            try {
                Statement stmt = conn.createStatement();
                String query =
                        "SELECT country.Name, country.Population "
                                + "FROM country "
                                + "WHERE country.Name LIKE ? ";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);

                ResultSet resultSet = preparedStatement.executeQuery();

                List<Country> result = new ArrayList<>();

                while(resultSet.next()) {
                    Country country = new Country();
                    country.setName(resultSet.getString("country.Name"));
                    country.setPopulation(resultSet.getInt("country.Population"));
                    result.add(country);
                }
                return result;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get country population");
            }
            return null;
        }
    }

    /**
     * Method to get a population of a country
     * @return int
     */
    public long getWorldPopulation()
    {
        try {
                Statement stmt = conn.createStatement();
                String query =
                        "SELECT SUM(country.Population) "
                                + "FROM country ";

                PreparedStatement preparedStatement = conn.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();

                long result = -1;

                while(resultSet.first()) {
                    result = resultSet.getLong("SUM(country.Population)");
                }
                return result;
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population");
        }
        return 0;
    }
}
