package com.napier.sem.queries;

import com.napier.sem.objects.Country;

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
     * Gets world population from highest to lowest.
     *
     * @return List of countries
     */
    public List<Country> getPopulationDescending() {
        // select name from country order by population desc;
        return getCountriesSortedDescending();
    }

    /**
     * Gets world population from lowest to highest.
     *
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
     *
     * @return List of countries
     */
    public List<Country> getContinentPopulationDescending(String Continent) {
        // select name from country order by population desc;
        return getContinentPopulation(Continent);
    }

    /**
     * Gets world population from lowest to highest.
     *
     * @return sorted countries
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

            String query = "SELECT continent " +
                    "FROM country " +
                    "WHERE continent LIKE ?"+
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
}
