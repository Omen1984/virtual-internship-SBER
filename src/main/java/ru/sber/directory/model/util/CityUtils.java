package ru.sber.directory.model.util;

import ru.sber.directory.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class CityUtils {
    public static List<City> parse() {
        List<City> directoryCities = new ArrayList<>();
        File path = new File("./src/main/resources/city_ru.csv");
        try (Scanner sc = new Scanner(path)) {

            while (sc.hasNext()) {
                String cityCSV = sc.nextLine();
                City city = parse(cityCSV);
                directoryCities.add(city);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return directoryCities;
    }

    public static void print(List<City> directoryCities) {
        directoryCities.forEach(System.out::println);
    }

    private static City parse(String cityCSV) {
        try (Scanner sc = new Scanner(cityCSV)) {
            sc.useDelimiter(";");
            sc.skip("\\d*");

            String name = sc.next();
            String region = sc.next();
            String district = sc.next();
            int population = sc.nextInt();
            String foundation = null;

            if (sc.hasNext()) foundation = sc.next();
            return new City(name, region, district, population, foundation);
        }
    }

    /**
     * @param cities
     * @return Отсортированный список городов по наименованию в алфавитном порядке по убыванию без учета регистра
     */
    public static List<City> sortByName(List<City> cities) {
        return cities.stream()
                .sorted(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())))
                .collect(Collectors.toList());
    }

    /**
     * @param cities
     * @return Отсортированный список городов по
     * федеральному округу и наименованию города внутри каждого федерального
     * округа в алфавитном порядке по убыванию с учетом регистра
     */
    public static List<City> sortByDistrictAndName(List<City> cities) {
        return cities.stream()
                .sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName))
                .collect(Collectors.toList());
    }

    /**
     * Метод преобразовывает список городов в массив и путем перебора массива
     * находит индекс элемента и значение с наибольшим количеством жителей города
     * и выводит его в консоль
     *
     * @param cities
     */
    public static void searchForCityWithMostPopulation(List<City> cities) {
        City[] cityArr = cities.stream()
                .toArray(City[]::new);

        int max = 0;
        int indexMax = 0;
        for (int i = 0; i < cityArr.length; i++) {
            int population = cityArr[i].getPopulation();
            if (population > max) {
                max = population;
                indexMax = i;
            }
        }
        System.out.println(String.format("[%d] = %d", indexMax, max));
    }

    /**
     * Void метод который возвращает количество городов в разрезе
     * регионов переданной в него коллекции с городами
     *
     * @param cities
     */
    public static void searchForNumberOfCities(List<City> cities) {
        Map<String, Integer> regions = new HashMap<>();

        cities.forEach(city -> regions.merge(city.getRegion(), 1, Integer::sum));
        regions.forEach((k, v) -> System.out.println(String.format("%s - %d", k, v)));
    }
}
