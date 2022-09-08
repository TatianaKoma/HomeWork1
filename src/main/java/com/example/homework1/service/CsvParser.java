package com.example.homework1.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CsvParser {
    Map<String, List<String>> getDataFromCsvFile() throws IOException;
}
