package com.example.listycity;


/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    /** The city name (e.g., "Edmonton"). */
    private String city;
    /** The province or territory (e.g., "Alberta"). */
    private String province;


    /**
     * Creates a City with a name and province/territory.
     * @param city the city name
     * @param province the province or territory name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }


    /**
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }


    /**
     * @return the province/territory name
     */
    String getProvinceName(){
        return this.province;
    }


    /**
     * Compares cities by their city names, lexicographically.
     * @param o the other city
     * @return negative/zero/positive according to String.compareTo
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }
}

