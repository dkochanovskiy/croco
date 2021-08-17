package ru.den.croco;

import ru.den.croco.interfaces.DirectoryParser;

import java.util.List;

public class DirectoryParserCsv implements DirectoryParser {
    @Override
    public List<String> readDirectory(String row) {
        if (!("\"city\";\"street\";\"house\";\"floor\"".equals(row))) {
            listRow.add(row);
        }

        //        String[] cities = row.split(";");
//
//        setCity.add(cities[0].substring(1, cities[0].length() - 1));

        return listRow;
    }
}
