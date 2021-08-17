package ru.den.croco.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public interface DirectoryParser {
    List<String> listRow = new ArrayList<>();
    HashSet<String> setRow = new HashSet<>();
    HashSet<String> setDuplicate = new HashSet<>();

    List<String> readDirectory (String row);

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
                        Collections.frequency(listRow, duplicate));
            }
        } else {
            System.out.println("Дубликатов не обнаружено");
        }
    }
}
