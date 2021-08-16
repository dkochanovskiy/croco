package ru.den.croco;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath;
        String row;
        List<String> listRow = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> setRow = new HashSet<>();
        HashSet<String> setDuplicate = new HashSet<>();
        List<HashMap<String, String>> cityFloor = new ArrayList<>();

        DirectoryParserXML xml = new DirectoryParserXML();

        while (true) {
            System.out.println("\nВведите путь до файла");
            filePath = reader.readLine();

            try {
                File file = new File(filePath);
                Scanner fileReader = new Scanner(file);

                while (fileReader.hasNextLine()) {
                    row = fileReader.nextLine();

                    if (filePath.startsWith("csv", filePath.length() - 3)) {
                        if (!("\"city\";\"street\";\"house\";\"floor\"".equals(row))) {
//                            String[] cities = row.split(";");

//                            setCity.add(cities[0].substring(1, cities[0].length() - 1));
                        }
                    }

                    if (filePath.startsWith("xml", filePath.length() - 3)) {
                        listRow = xml.readDirectory(row);
                    }

                    if (!setRow.add(row)) {
                        setDuplicate.add(row);
                    }
                }

                // вывод
                if (setDuplicate.size() != 0) {
                    for (String duplicate : setDuplicate) {
                        System.out.println("Дубликат: " + duplicate + ", количество повторений: " +
                                Collections.frequency(listRow, duplicate));
                    }
                } else {
                    System.out.println("Дубликатов не обнаружено");
                }

                for (String element : listRow) {
                    String city = element.substring(12);
                    city = city.substring(0, city.indexOf("\""));

                    String floor = element.substring(element.indexOf("floor") + 7, element.length() - 4);
                    HashMap<String, String> one_store = new HashMap<>();
                    one_store.put(city, floor);
                    cityFloor.add(one_store);
                    System.out.println(cityFloor);
                }

                //конец вывода
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Файл по указанному пути не найден");
            }
        }
    }
}
