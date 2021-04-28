package com.napier.sem.queries;

import com.napier.sem.objects.District;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DistrictQueries {
    private Connection conn;

    public DistrictQueries(Connection conn) { this.conn = conn; }

    /**
     * Gets population of a district
     * @param name
     * @return
     */
    public District getPopulation(String name)
    {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("District is null or empty");
        } else {
            try {
                Statement stmt = conn.createStatement();
                String query =
                        "SELECT district, SUM(population) as population "
                        + "FROM city "
                        + "WHERE district LIKE ? "
                        + "GROUP BY district";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    District district = new District();
                    district.setName(resultSet.getString("district"));
                    district.setPopulation(resultSet.getLong("population"));
                    return  district;
                } else {
                    throw new Exception("No district found");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get district population");
            }
            return null;
        }
    }
}
