package ru.den.croco.interfaces;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryParserTest {
    int oneStore = 0;
    int twoStore = 0;
    int threeStore = 0;
    int fourStore = 0;
    int fiveStore = 0;

    List<String> listCityFloor = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        listCityFloor.add("Москва:1");
        listCityFloor.add("Москва:2");
        listCityFloor.add("Москва:2");
        listCityFloor.add("Москва:5");
        listCityFloor.add("Москва:4");
        listCityFloor.add("Москва:1");
        listCityFloor.add("Москва:3");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        listCityFloor.clear();
    }

    @org.junit.jupiter.api.Test
    void getFloorForCity() {
        for (String cityFloor : listCityFloor) {
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

        assertEquals(2, oneStore);
        assertEquals(2, twoStore);
        assertEquals(1, threeStore);
        assertEquals(1, fourStore);
        assertEquals(1, fiveStore);
    }
}