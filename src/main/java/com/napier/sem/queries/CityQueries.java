package com.napier.sem.queries;

import com.napier.sem.objects.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityQueries {
    private Connection conn;

    public CityQueries(Connection conn)
    {
        this.conn = conn;
    }

    /**
     *
     * @param name
     * @return list of cities
     */
    public List<City> getCityPopulation(String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Provided city is null or empty");
        }
        else
        {
            try
            {
                Statement stmt = conn.createStatement();
                String query =
                        "SELECT city.ID, city.Name, city.Population "
                                + "FROM city "
                                + "WHERE city.Name LIKE ? ";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);

                ResultSet resultSet = preparedStatement.executeQuery();

                List<City> cities = new ArrayList<City>();

                while(resultSet.next()) {
                    City city = new City();
                    city.setID(resultSet.getInt("city.ID"));
                    city.setName(resultSet.getString("city.Name"));
                    city.setPopulation(resultSet.getInt("city.Population"));
                    cities.add(city);
                }
                return cities;

            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get city population");
            }
            return null;
        }
    }

    /**
     *
     * @param district
     * @return list of cities in a district specified by the user organised by largest to smallest
     */
    public List<City> getCitiesInDistrictByLargestToSmallestPopulation(String district)
    {
        if (district == null || district.isEmpty()) {
            throw new IllegalArgumentException("District is null or empty");
        } else {
            try {
                Statement stmt = conn.createStatement();
                String query =
                        "SELECT city.ID, city.Name, country.Name, city.District, city.Population "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE District LIKE ? "
                        + "ORDER BY city.Population DESC";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, district);

                ResultSet resultSet = preparedStatement.executeQuery();

                List<City> cities = new ArrayList<City>();


                while(resultSet.next()) {
                    City city = new City();
                    city.setID(resultSet.getInt("city.ID"));
                    city.setName(resultSet.getString("city.Name"));
                    city.setCountry(resultSet.getString("country.Name"));
                    city.setDistrict(resultSet.getString("city.District"));
                    city.setPopulation(resultSet.getInt("city.Population"));
                    cities.add(city);
                }
                return cities;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get cities in district");
            }
            return null;
        }
    }

    /**
     *
     * @param country
     * @return list of cities in country ordered by population
     */
    public List<City> getCitiesInCountryByLargestToSmallestPopulation(String country)
    {
        if (country == null || country.isEmpty()) {
            throw new IllegalArgumentException("District is null or empty");
        } else {
            try {
                Statement stmt = conn.createStatement();
                String query =
                        "SELECT city.ID, city.Name, country.Name, city.District, city.Population "
                                + "FROM city JOIN country ON city.CountryCode = country.Code "
                                + "WHERE country.Name LIKE ? "
                                + "ORDER BY city.Population DESC";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, country);

                ResultSet resultSet = preparedStatement.executeQuery();

                List<City> cities = new ArrayList<City>();


                while(resultSet.next()) {
                    City city = new City();
                    city.setID(resultSet.getInt("city.ID"));
                    city.setName(resultSet.getString("city.Name"));
                    city.setCountry(resultSet.getString("country.Name"));
                    city.setDistrict(resultSet.getString("city.District"));
                    city.setPopulation(resultSet.getInt("city.Population"));
                    cities.add(city);
                }
                return cities;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get cities in country");
            }
            return null;
        }
    }
    public List<City> getTopNPopulatedCitiesInAContinentDescending(String continent, int n)
    {
        List<City> result = getCitiesInAContinentDescending(continent);

        if (n >= result.size()) {
            throw new IllegalArgumentException("The provided number is invalid. The number of cities in " + continent + " is " + result.size());
        }

        return result.subList(0, n);
    }

    /**
     * Helper method to get Top N cities in a continent organised by largest population to smallest
     * @param continent
     * @return list of cities
     */
    public List<City> getCitiesInAContinentDescending(String continent)
    {
        if (continent == null || continent.isEmpty()) {
            throw new IllegalArgumentException("Continent is null or empty");
        } else {
            try {
                Statement stmt = conn.createStatement();
                String query =
                        "SELECT city.ID, city.Name, country.Name, city.District, city.Population "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent LIKE ? "
                        + "ORDER BY city.Population DESC";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, continent);

                ResultSet resultSet = preparedStatement.executeQuery();

                List<City> cities = new ArrayList<City>();


                while(resultSet.next()) {
                    City city = new City();
                    city.setID(resultSet.getInt("city.ID"));
                    city.setName(resultSet.getString("city.Name"));
                    city.setCountry(resultSet.getString("country.Name"));
                    city.setDistrict(resultSet.getString("city.District"));
                    city.setPopulation(resultSet.getInt("city.Population"));
                    cities.add(city);
                }
                return cities;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get cities in a continent");
            }
            return null;
        }
    }

    /**
     * Helper method to get top n populated cities in the world where N is provided by the user
     * @return a list of cities
     */
    public List<City> getCitiesInTheWorld()
    {
        try {
            Statement stmt = conn.createStatement();
            String query =
                    "SELECT city.ID, city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON city.CountryCode = country.Code "
                    + "ORDER BY city.Population DESC";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<City> cities = new ArrayList<City>();

            while(resultSet.next()) {
                City city = new City();
                city.setID(resultSet.getInt("city.ID"));
                city.setName(resultSet.getString("city.Name"));
                city.setCountry(resultSet.getString("country.Name"));
                city.setDistrict(resultSet.getString("city.District"));
                city.setPopulation(resultSet.getInt("city.Population"));
                cities.add(city);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in the world");
        }
        return null;
    }

    /**
     * Get top n populated cities in the world
     * @param n
     * @return a list of cities
     */
    public List<City> getTopNPopulatedCitiesInTheWorld(int n)
    {
        List<City> result = getCitiesInTheWorld();

        if (n >= result.size()) {
            throw new IllegalArgumentException("The provided number is invalid. The number of cities in the world is " + result.size());
        }

        return result.subList(0, n);
    }

}
