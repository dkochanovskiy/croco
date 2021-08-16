package ru.den.croco.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface DirectoryParser {
    List<String> listRow = new ArrayList<>();

    default List<String> readDirectory (String row) {
        if (!("<root>".equals(row)) && !("</root>".equals(row)) &&
                !("<?xml version=\"1.0\" encoding=\"utf-8\"?>".equals(row))) {
            listRow.add(row);
        }

        return listRow;
    }
}
