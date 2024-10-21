package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataPointRepository {

    private static Map<Float, Float> dataPoint = new HashMap<>();

    public static Map<Float, Float> getDataPoint() {
        return readFileToFloatMap("data/coordinates.txt");
    }

    public static void setDataPoint(Map<Float, Float> dataPoint) {
        DataPointRepository.dataPoint = dataPoint;
    }

    public static Map<Float, Float> readFileToFloatMap(String filePath) {
        Map<Float, Float> floatMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Split each line by space or any delimiter that separates the floats
                String[] parts = line.trim().split(",");

                if (parts.length == 2) {  // Ensure each line contains exactly two numbers
                    // Parse the floats and add them to the map
                    float key = Float.parseFloat(parts[0]);
                    float value = Float.parseFloat(parts[1]);
                    floatMap.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle exceptions (file not found, etc.)
        }

        return floatMap;
    }

}