package ru.den.croco;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath;
        String row;
        Set<String> cityList = new HashSet<>();
        List<String> listCityFloor = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> setRow = new HashSet<>();
        HashSet<String> setDuplicate = new HashSet<>();

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
                        DirectoryParserCSV csv = new DirectoryParserCSV();
                        listCityFloor = csv.readDirectory(row);
                    }

                    if (filePath.startsWith("xml", filePath.length() - 3)) {
                        listCityFloor = xml.readDirectory(row);
                    }

                    cityList = xml.getCityList(listCityFloor);
                    
                    setDuplicate = xml.searchDuplicates(row);
                }

                for (String item : cityList) {
                    System.out.println(item);
                }

                xml.showDuplicates(setDuplicate);

                setDuplicate.clear();

                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Файл по указанному пути не найден");
            }
        }
    }
}
