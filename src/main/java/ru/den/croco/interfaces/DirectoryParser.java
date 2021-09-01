package ru.den.croco.interfaces;

import java.util.*;

public interface DirectoryParser {
    List<String> listCityFloor = new ArrayList<>();
    HashSet<String> setRow = new HashSet<>();
    HashSet<String> setDuplicate = new HashSet<>();

    List<String> readDirectory (String row);

    default Set<String> getCityList (List<String> listCityFloor) {
        Set<String> cityList = new HashSet<>();
        for (String element : listCityFloor) {
            cityList.add(element.split(":")[0]);
        }

        return cityList;
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
                System.out.println("Дубликат: " + duplicate + ", количество повторений: " +
                        Collections.frequency(listCityFloor, duplicate));
            }
        } else {
            System.out.println("Дубликатов не обнаружено");
        }
    }
}
