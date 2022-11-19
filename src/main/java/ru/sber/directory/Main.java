package ru.sber.directory;

import ru.sber.directory.model.City;
import ru.sber.directory.model.util.CityUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<City> cities = CityUtils.parse();
        //Поиск максимума в массиве
        CityUtils.SearchForCityWithMostPopulation(cities);
    }

}
