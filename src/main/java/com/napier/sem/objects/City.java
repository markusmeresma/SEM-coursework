package com.napier.sem.objects;

public class City {

    private int ID;

    private String name;

    private int population;

    /**
     *
     * @return ID
     */
    public int getID() {
        return this.ID;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return population
     */
    public int getPopulation() {
        return this.population;
    }

    /**
     *
     * @param _ID
     */
    public void setID(int _ID) {
        this.ID = _ID;
    }

    /**
     *
     * @param _name
     */
    public void setName(String _name) {
        this.name = name;
    }

    /**
     *
     * @param _population
     */
    public void setPopulation(int _population) {
        this.population = _population;
    }
}
