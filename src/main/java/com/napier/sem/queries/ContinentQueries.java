package com.napier.sem.queries;

import com.napier.sem.objects.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContinentQueries {
    private Connection conn;

    public ContinentQueries(Connection conn) {
        this.conn = conn;
    }

    /**
     * Gets population from highest to lowest.
     *
     * @return List of countries
     */
    public List<Country> getPopulationDescending() {
        // select name from country order by population desc;
        return getCountriesSortedDescending();
    }

    /**
     * Gets population from lowest to highest.
     *
     * @return sorted countries
     */
    public List<Country> getPopulationAscending() {
        List<Country> result = getCountriesSortedDescending();
        Collections.reverse(result);
        return result;
    }

    /**
     * Gets population from highest to lowest.
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
}
