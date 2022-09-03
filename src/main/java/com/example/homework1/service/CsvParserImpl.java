package com.example.homework1.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CsvParserImpl implements CsvParser {
    public static final String DELIMITER = ",";

    @Override
    public Map<String, List<String>> getDataFromCsvFile(String csvFile) {
        Map<String, List<String>> questionsWithAnswers = new LinkedHashMap<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFile))) {
            String line = " ";

            while ((line = csvReader.readLine()) != null) {
                String[] tempArr = line.split(DELIMITER);
                String question = tempArr[0];
                List<String> answersList = new ArrayList<>();
                for (int i = 1; i < tempArr.length; i++) {
                    answersList.add(tempArr[i]);
                }
                questionsWithAnswers.put(question, answersList);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return questionsWithAnswers;
    }
}
