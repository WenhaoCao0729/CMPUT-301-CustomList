package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach

    public void createList(){
        list = new CustomList(null,new ArrayList<City>());

    }

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton","Alberta");
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Edmonton","Alberta"));
        assertEquals(listSize +1, list.getCount());
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1,cityList.getCities().size());
        City city = new City("Regina","Saskatchewan");
        cityList.add(city);

        assertEquals(2,cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));

    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife","Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class,()->{
            cityList.add(city);
        });
    }

    @Test
    void testGetCities(){
        CityList cityList = mockCityList();

        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown","Prince Edward Island");
        cityList.add(city);

        assertEquals(0,city.compareTo(cityList.getCities().get(0)));
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CityList cityList = mockCityList();
        City city = new City("Toronto","Ontario");

        assertEquals(true,cityList.hasCity(city));

        cityList.add(city);

        assertEquals(true,cityList.hasCity(city));

    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();

        City city = new City("Halifax","Nova Scotia");
        cityList.add(city);

        assertEquals(true,cityList.hasCity(city));
        cityList.delete(city);
        //assertEquals(true,cityList.hasCity(city));

    }

    @Test
    void testCountcities(){
        CityList cityList = mockCityList();

        assertEquals(1,cityList.countCities());

        City city = new City("Halifax","Nova Scotia");
        City city2 = new City("London","Ontario");

        assertEquals(1,cityList.countCities());
    }

}
