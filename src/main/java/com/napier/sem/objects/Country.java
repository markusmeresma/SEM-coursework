package com.napier.sem.objects;

public class Country {

    private final String name;

    private final String continent;

    private final String region;

    private final int population;

    public Country(String name, String continent, String region, int population) {
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                '}';
    }
}
