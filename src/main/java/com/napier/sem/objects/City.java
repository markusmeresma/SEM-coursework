package com.napier.sem.objects;

public class City {

    private int ID;

    private String name;

    private int population;

    private String country;

    private String district;

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
     * @return country
     */
    public String getCountry() { return this.country; }

    /**
     *
     * @return district
     */
    public String district() {return this.district; }

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

    /**
     *
     * @param _country
     */
    public void setCountry(String _country) { this.country = _country; }

    /**
     *
     * @param _district
     */
    public void setDistrict(String _district) { this.district = _district; }
}
