package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Test on hasCity() method.
     */
    @org.junit.Test
    public void hasCityTest() {
        CustomList list = MockCityList();
        int listSize = list.getCount();
        Assert.assertEquals(listSize, list.getCount());
        City cityNew = new City("Calgary", "Alberta");
        list.add(cityNew);
        Assert.assertEquals(listSize + 1, list.getCount());
        assertTrue(list.hasCity(cityNew));
    }

    /**
     * Test on deleteCity() method when it functions perfectly.
     */
    @org.junit.Test
    public void deleteCityTest() {
        CustomList list = MockCityList();
        int listSize = list.getCount();
        Assert.assertEquals(listSize, list.getCount());
        City cityNew = new City("Calgary", "Alberta");
        list.add(cityNew);
        Assert.assertEquals(listSize + 1, list.getCount());
        list.deleteCity(cityNew);
        Assert.assertEquals(listSize, list.getCount());
        assertFalse(list.hasCity(cityNew));
    }

    /**
     *  Test on countCities() method.
     */
    @org.junit.Test
    public void countCitiesTest() {
        CustomList list = MockCityList();
        int listSize = list.getCount();
        Assert.assertEquals(listSize, list.getCount());
        Assert.assertEquals(listSize, list.countCities());
        City cityNew = new City("Calgary", "Alberta");
        list.add(cityNew);
        Assert.assertEquals(listSize + 1, list.getCount());
        Assert.assertEquals(listSize + 1, list.countCities());
        list.deleteCity(cityNew);
        Assert.assertEquals(listSize, list.getCount());
        Assert.assertEquals(listSize, list.countCities());
    }
}
