package ru.den.croco;

import ru.den.croco.interfaces.DirectoryParser;

import java.util.List;

public class DirectoryParserXML implements DirectoryParser {
    @Override
    public List<String> readDirectory(String row) {
        if (!("<root>".equals(row)) && !("</root>".equals(row)) &&
                !("<?xml version=\"1.0\" encoding=\"utf-8\"?>".equals(row))) {
            listRow.add(row);
        }

        //                for (String element : listRow) {
//                    String city = element.substring(12);
//                    city = city.substring(0, city.indexOf("\""));
//
//                    String floor = element.substring(element.indexOf("floor") + 7, element.length() - 4);
//                    HashMap<String, String> one_store = new HashMap<>();
//                    one_store.put(city, floor);
//                    cityFloor.add(one_store);
//                    System.out.println(cityFloor);
//                }

        return listRow;
    }
}
