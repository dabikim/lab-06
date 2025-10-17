package com.example.listycity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * This is a class that keeps track of a list of City objects.
 */
public class CityList {
    /** Backing store for City objects. */
    private final List<City> cities = new ArrayList<>();


    /**
     * Adds a city if it does not already exist (by exact name+province match).
     * @param city candidate city to add
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (hasCity(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }


    /**
     * @return a NEW sorted list (ascending by city name). The original list is not mutated.
     */
    public List<City> getCities() {
        List<City> copy = new ArrayList<>(cities);
        Collections.sort(copy);
        return copy;
    }


    /**
     * Returns whether the given city (by name+province) is present.
     * @param city city to check
     * @return true if present; false otherwise
     */
    public boolean hasCity(City city) {
        for (City c : cities) {
            if (c.getCityName().equals(city.getCityName())
                    && c.getProvinceName().equals(city.getProvinceName())) {
                return true;
            }
        }
        return false;
    }


    /**
     * Removes the given city (by name+province). If not present, throws an exception.
     * @param city city to remove
     * @throws IllegalArgumentException if the city does not exist
     */
    public void delete(City city) {
        boolean removed = false;
        Iterator<City> it = cities.iterator();
        while (it.hasNext()) {
            City c = it.next();
            if (c.getCityName().equals(city.getCityName())
                    && c.getProvinceName().equals(city.getProvinceName())) {
                it.remove();
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * @return how many cities are in the list
     */
    public int countCities() {
        return cities.size();
    }
}

