package ru.isu.model;

public class Country {
    private String code;
    private String name;
    private String continent;
    private Double surfaceArea;
    private Integer population;


    //constructors
    public Country() {}

    public Country(String code, String name, String continent, Double surfaceArea, Integer population) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
    }

    //getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    public Integer getPopulation() {
        return population;
    }

    //setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setSurfaceArea(Double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}