package ru.den.croco.interfaces;

import java.util.*;

public interface DirectoryParser {
    List<String> listCityFloor = new ArrayList<>();
    HashSet<String> setRow = new HashSet<>();
    HashSet<String> setDuplicate = new HashSet<>();
    Set<String> cityList = new HashSet<>();

    List<String> readDirectory (String row);

    default Set<String> getCityList (List<String> listCityFloor) {
        for (String element : listCityFloor) {
            cityList.add(element.split(":")[0]);
        }

        return cityList;
    }

    default void getFloorForCity (List<String> listCityFloor, Set<String> cityList) {
        int oneStore = 0;
        int twoStore = 0;
        int threeStore = 0;
        int fourStore = 0;
        int fiveStore = 0;

        for (String city : cityList) {
            for (String cityFloor : listCityFloor) {
                if (city.equals(cityFloor.split(":")[0])) {
                    if ("1".equals(cityFloor.split(":")[1])) {
                        oneStore++;
                    }

                    if ("2".equals(cityFloor.split(":")[1])) {
                        twoStore++;
                    }

                    if ("3".equals(cityFloor.split(":")[1])) {
                        threeStore++;
                    }

                    if ("4".equals(cityFloor.split(":")[1])) {
                        fourStore++;
                    }

                    if ("5".equals(cityFloor.split(":")[1])) {
                        fiveStore++;
                    }
                }
            }

            System.out.println(city + ": количество одноэтажек: " + oneStore);
            System.out.println(city + ": количество двухэтажек: " + twoStore);
            System.out.println(city + ": количество трехэтажек: " + threeStore);
            System.out.println(city + ": количество четырехэтажек: " + fourStore);
            System.out.println(city + ": количество пятиэтажек: " + fiveStore);

            oneStore = 0;
            twoStore = 0;
            threeStore = 0;
            fourStore = 0;
            fiveStore = 0;
        }

        cityList.clear();
        listCityFloor.clear();
    }

    default HashSet<String> searchDuplicates (String row) {
        if (!setRow.add(row)) {
            setDuplicate.add(row);
        }

        return setDuplicate;
    }

    default void showDuplicates (HashSet<String> setDuplicate) {
        if (setDuplicate.size() != 0) {
            for (String duplicate : setDuplicate) {
                System.out.println("\nДубликат: " + duplicate + ", количество повторений: " +
                        Collections.frequency(listCityFloor, duplicate) + "\n");
            }
        } else {
            System.out.println("\nДубликатов не обнаружено\n");
        }
    }
}
