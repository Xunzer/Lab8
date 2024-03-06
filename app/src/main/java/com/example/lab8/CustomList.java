package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *for the first phase it will be
     empty * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This function checks if the CityList contains the specific city.
     * @param city The city to be checked in the list.
     * @return Return a boolean that can be true or false, true means the list contained that city, false means that city is not in the list.
     */
    public boolean hasCity(City city) {
        if (cities.contains(city)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This is a function that removes a specific city from the list
     * @param city This is a candidate city to be removed.
     * @throws IllegalArgumentException Will throw an exception if the targeted city doesn't exist in the list.
     */
    public void deleteCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException("That city doesn't exist.");
        }
    }

    /**
     * This is a function that counts the number of cities in the cityList.
     * @return Return the number of cities in the list as int type.
     */
    public int countCities() {
        int count = 0;
        for (City city : cities) {
            count++;
        }
        return count;
    }
}
