package com.example.homework1.service;

import java.util.List;
import java.util.Map;

public interface CsvParser {
    Map<String, List<String>> getDataFromCsvFile(String fileName);
}
