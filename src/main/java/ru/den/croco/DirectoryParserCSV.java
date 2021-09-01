package ru.den.croco;

import ru.den.croco.interfaces.DirectoryParser;
import java.util.List;

public class DirectoryParserCSV implements DirectoryParser {
    @Override
    public List<String> readDirectory(String row) {
        if (!("\"city\";\"street\";\"house\";\"floor\"".equals(row))) {
            String[] parts = row.split(";");
            String city = parts[0].substring(1, (parts[0].length() - 1));
            listCityFloor.add(city + ":" + parts[3]);
        }

        return listCityFloor;
    }
}
