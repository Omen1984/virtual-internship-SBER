package ru.sber.directory;

import ru.sber.directory.model.City;
import ru.sber.directory.model.util.CityUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<City> cities = CityUtils.parse();
        //Сортировка по наименованию города
        //CityUtils.print(CityUtils.sortByName(cities));
        //Сортировка по двум критериям
        CityUtils.print(CityUtils.sortByDistrictAndName(cities));
    }

}
