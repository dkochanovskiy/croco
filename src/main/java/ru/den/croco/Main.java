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
        HashSet<String> setCity = new HashSet<>();

        System.out.println("Enter the path to the file");
        filePath = reader.readLine();

        try {
            File file = new File(filePath);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                row = fileReader.nextLine();
                listRow.add(row);
                
                String[] cities = row.split(";");

                setCity.add(cities[0].substring(1, cities[0].length() - 1));

                if (!setRow.add(row)) {
                    setDuplicate.add(row);
                }
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (setDuplicate.size() == 0) {
            System.out.println("No duplicate lines found");
        } else {
            for (String duplicate : setDuplicate) {
                System.out.println("Duplicate: " + duplicate + ", number of occurrences: " +
                        Collections.frequency(listRow, duplicate));
            }
        }

        for (String city : setCity) {
            System.out.println(city);
        }

    }
}
