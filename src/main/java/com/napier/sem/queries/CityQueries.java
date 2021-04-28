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

}
