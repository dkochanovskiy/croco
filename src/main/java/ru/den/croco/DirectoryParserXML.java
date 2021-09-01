package ru.den.croco;

import ru.den.croco.interfaces.DirectoryParser;
import java.util.List;

public class DirectoryParserXML implements DirectoryParser {
    @Override
    public List<String> readDirectory(String row) {
        if (!("<root>".equals(row)) && !("</root>".equals(row)) &&
                !("<?xml version=\"1.0\" encoding=\"utf-8\"?>".equals(row))) {
            String city = row.substring(12);
            city = city.substring(0, city.indexOf("\""));
            String floor = row.substring(row.indexOf("floor") + 7, row.length() - 4);
            listCityFloor.add(city + ":" + floor);
        }

        return listCityFloor;
    }
}
