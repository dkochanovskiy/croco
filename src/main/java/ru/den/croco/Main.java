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
                        DirectoryParserCsv csv = new DirectoryParserCsv();
                        listRow = csv.readDirectory(row);
                    }

                    if (filePath.startsWith("xml", filePath.length() - 3)) {
                        listRow = xml.readDirectory(row);
                    }

                    setDuplicate = xml.searchDuplicates(row);
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
