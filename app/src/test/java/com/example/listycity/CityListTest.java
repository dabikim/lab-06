package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private City mockCity() { return new City("Edmonton", "Alberta"); }

    private CityList mockCityList() {
        CityList list = new CityList();
        list.add(mockCity());
        return list;
    }

    @Test
    void testAdd() {
        CityList list = mockCityList();
        City regina = new City("Regina", "Saskatchewan");
        list.add(regina);
        assertTrue(list.hasCity(regina));
        assertEquals(2, list.countCities());
    }

    @Test
    void testAddExceptionOnDuplicate() {
        CityList list = mockCityList();
        assertThrows(IllegalArgumentException.class, () -> list.add(mockCity()));
    }

    @Test
    void testHasCity() {
        CityList list = mockCityList();
        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(list.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDelete() {
        CityList list = mockCityList();
        list.delete(new City("Edmonton", "Alberta"));
        assertEquals(0, list.countCities());
        assertFalse(list.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testDeleteThrowsIfMissing() {
        CityList list = mockCityList();
        assertThrows(IllegalArgumentException.class,
                () -> list.delete(new City("Yellowknife", "Northwest Territories")));
    }

    @Test
    void testCountCities() {
        CityList list = new CityList();
        list.add(new City("Halifax", "Nova Scotia"));
        list.add(new City("Victoria", "British Columbia"));
        assertEquals(2, list.countCities());
    }

    @Test
    void testGetCitiesSorted() {
        CityList list = new CityList();
        City b = new City("Banff", "Alberta");
        City e = new City("Edmonton", "Alberta");
        City c = new City("Calgary", "Alberta");
        list.add(e);
        list.add(c);
        list.add(b);
        var sorted = list.getCities();
        assertEquals("Banff", sorted.get(0).getCityName());
        assertEquals("Calgary", sorted.get(1).getCityName());
        assertEquals("Edmonton", sorted.get(2).getCityName());
    }
}
