package ru.sber.directory;

import ru.sber.directory.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File path = new File("./src/main/resources/city_ru.csv");
        Scanner sc = new Scanner(path);
        List<City> directoryCities = new ArrayList<>();

        while (sc.hasNext()) {
            String cityCSV = sc.nextLine();
            City city = parseCSVtoCity(cityCSV);
            directoryCities.add(city);
        }

        directoryCities.forEach(System.out::println);
    }

    public static City parseCSVtoCity(String cityCSV) {
        String[] cityData = cityCSV.split(";");

        if (cityData.length < 5) throw new RuntimeException(
                String.format("Данных не достаточно для построения объекта, минимум = 5, предоставлено = %d",
                        cityData.length));

        long id = Long.parseLong(cityData[0]);
        String name = cityData[1];
        String region = cityData[2];
        String district = cityData[3];
        int population = Integer.parseInt(cityData[4]);
        String foundation = "NO DATA";

        if (cityData.length == 6) foundation = cityData[5];

        return new City(id, name, region, district, population, foundation);
    }
}
