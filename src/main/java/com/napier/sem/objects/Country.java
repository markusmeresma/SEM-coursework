package com.napier.sem.objects;

public class Country {

    private String name;

    private String continent;

    private String region;

    private int population;

    public Country() { }

    public Country(String name, String continent, String region, int population) {
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public String getName() { return name; }

    public String getContinent() { return continent; }

    public String getRegion() { return region; }

    public void setPopulation(int _population) { this.population = _population; }

    public void setName(String _name) { this.name = _name; }

    public void setContinent(String _continent) { this.continent = _continent; }

    public void setRegion(String _region) { this.region = _region; }

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
