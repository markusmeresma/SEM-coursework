package com.napier.sem.queries;

import com.napier.sem.objects.Continent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContinentQueries {
    private Connection conn;

    public ContinentQueries(Connection conn) { this.conn = conn; }

    /**
     * Method for getting a population of a continent
     * @param name
     * @return
     */
    public Continent getContinentPopulation(String name)
    {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Continent is null or empty");
        } else {
            try {
                Statement stmt = conn.createStatement();
                String query =
                        "SELECT continent, SUM(population) as population "
                        + "FROM country "
                        + "WHERE continent LIKE ? "
                        + "GROUP BY continent";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);

                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()) {
                    Continent continent = new Continent();
                    continent.setName(resultSet.getString("continent"));
                    continent.setPopulation(resultSet.getLong("population"));
                    return continent;
                } else {
                    throw new IllegalArgumentException("Continent not found");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get continent population");
            }
            return null;
        }
    }
}
